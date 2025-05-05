// https://www.codetree.ai/ko/trails/complete/curated-cards/intro-nearest-point/description

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

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
            if ((this.x + this.y) != (o.x + o.y))
                return this.x + this.y - (o.x + o.y);
            if (this.x != o.x)
                return this.x - o.x;
            return this.y - o.y;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        Queue<Point> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            pq.offer(new Point(sc.nextInt(), sc.nextInt()));
        }
        for (int i = 0; i < m; i++) {
            pq.add(new Point(pq.peek().x + 2, pq.poll().y + 2));
        }
        System.out.println(pq.peek().x + " " + pq.poll().y);

    }
}