// https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-remove-point/description

import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static class Point implements Comparable<Point> {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point other) {
            if (this.x == other.x) {
                return Integer.compare(this.y, other.y);
            }
            return Integer.compare(this.x, other.x);
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        TreeSet<Point> set = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            set.add(new Point(sc.nextInt(), sc.nextInt()));
        }
        for (int i = 0; i < m; i++) {
            Point p = set.ceiling(new Point(sc.nextInt(), 0));
            if (p == null) {
                p = new Point(-1, -1);
            } else {
                set.remove(p);
            }
            System.out.println(p.x + " " + p.y);
        }
    }
}