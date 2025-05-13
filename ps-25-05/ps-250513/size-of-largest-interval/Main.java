// https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-size-of-largest-interval/description

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static class Point {
        int x;
        int v;

        Point(int x, int v) {
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

            points.add(new Point(x1, +1));
            points.add(new Point(x2, -1));
        }

        Collections.sort(points, (x, y) -> (x.x - y.x));

        int cur = 0;
        int curVal = Integer.MIN_VALUE;
        int ans = 0;
        int cnt = 0;
        int prvcnt = 0;
        int start = 0;

        while (cur < points.size()) {
            curVal = points.get(cur).x;
            cnt += points.get(cur).v;
            cur++;
            while (cur < points.size() && points.get(cur).x == curVal) {
                cnt += points.get(cur).v;
                cur++;
            }
            if (prvcnt == 0 && cnt > 0) {
                start = curVal;
            }
            if (prvcnt > 0 && cnt == 0) {
                ans = Math.max(ans, curVal - start);
            }
            prvcnt = cnt;
        }
        System.out.println(ans);
    }
}