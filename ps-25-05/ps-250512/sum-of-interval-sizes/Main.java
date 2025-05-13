// https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-sum-of-interval-sizes/description

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static class Point {
        int x;
        int v;

        Point(int x, int y) {
            this.x = x;
            this.v = y;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<Point> points = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            int x1 = sc.nextInt();
            int x2 = sc.nextInt();
            points.add(new Point(x1, +1));
            points.add(new Point(x2, -1));
        }

        Collections.sort(points, (x, y) -> (x.x - y.x));

        int ans = 0;
        int start = 0;
        int cnt = 0;

        for (Point p : points) {
            if (cnt == 0) {
                cnt += p.v;
                start = p.x;
            } else {
                cnt += p.v;
                if (cnt == 0) {
                    ans += p.x - start;
                }
            }
        }

        System.out.println(ans);
    }

}