// https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-computer-hours/description

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static class Point {
        int person;
        int x;
        int v;

        Point(int p, int x, int v) {
            person = p;
            this.x = x;
            this.v = v;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Queue<Integer> pcs = new PriorityQueue<>();
        int[] peoples = new int[100_001];

        for (int i = 0; i < 100_001; i++) {
            if (i != 0)
                pcs.add(i);
            peoples[i] = Integer.MIN_VALUE;
        }

        List<Point> points = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            int x1 = sc.nextInt();
            int x2 = sc.nextInt();
            points.add(new Point(i, x1, +1));
            points.add(new Point(i, x2, -1));
        }
        Collections.sort(points, (x, y) -> {
            if (x.x == y.x)
                return x.v - y.v;
            return x.x - y.x;
        });

        for (Point p : points) {
            if (p.v == 1) {
                peoples[p.person] = pcs.poll();
            } else {
                pcs.add(peoples[p.person]);
            }
        }

        for (int i : peoples) {
            if (i == Integer.MIN_VALUE)
                continue;
            System.out.print(i + " ");
        }
    }
}
