// https://www.codetree.ai/ko/trails/complete/curated-cards/intro-frendly-point/description

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
        public int compareTo(Main.Point o) {
            if (this.x != o.x) {
                return this.x - o.x;
            } else {
                return this.y - o.y;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeSet<Point> set = new TreeSet<>();
        int n = sc.nextInt();
        int m = sc.nextInt();

        for (int i = 0; i < n; i++) {
            set.add(new Point(sc.nextInt(), sc.nextInt()));
        }
        for (int i = 0; i < m; i++) {
            Point p = set.ceiling(new Point(sc.nextInt(), sc.nextInt()));
            if (p == null) {
                p = new Point(-1, -1);
            }
            System.out.println(p.x + " " + p.y);

        }
    }
}