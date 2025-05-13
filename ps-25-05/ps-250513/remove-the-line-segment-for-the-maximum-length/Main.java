// https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-remove-the-line-segment-for-the-maximum-length/description

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static class Point {
        int idx;
        int x;
        int v;

        Point(int idx, int x, int v) {
            this.idx = idx;
            this.x = x;
            this.v = v;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Point> points = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int x1 = sc.nextInt();
            int x2 = sc.nextInt();

            points.add(new Point(i, x1, 1));
            points.add(new Point(i, x2, -1));
        }

        Collections.sort(points, (x, y) -> (x.x - y.x));

        Set<Integer> running = new HashSet<>();
        long[] alone = new long[n];

        int prevX = points.get(0).x;
        long all = 0;
        int cnt = 0;

        for (Point p : points) {
            if (p.x > prevX) {
                long len = (long) p.x - prevX;

                if (cnt > 0)
                    all += len;
                if (cnt == 1) {
                    alone[running.iterator().next()] += len;
                }

                prevX = p.x;
            }

            if (p.v == 1) {
                running.add(p.idx);
                cnt++;
            } else {
                running.remove(p.idx);
                cnt--;
            }
        }

        long min = Long.MAX_VALUE;

        for (long i : alone) {
            min = Math.min(min, i);
        }
        System.out.println(all - min);

    }
}