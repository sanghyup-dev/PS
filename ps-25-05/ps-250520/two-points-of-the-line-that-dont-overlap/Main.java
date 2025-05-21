// https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-two-points-of-the-line-that-dont-overlap/description

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static class Line {
        long s;
        long e;

        Line(long s, long e) {
            this.s = s;
            this.e = e;
        }
    }

    public static int n;
    public static int m;
    public static List<Line> lines;

    public static boolean possible(long dist) {
        long cur = (long) -1e18 - 1;
        long cnt = 0;
        for (Line l : lines) {
            if (l.s - cur >= dist)
                cur = l.s;
            else {
                if (l.e < (cur + dist))
                    continue;
                cur += dist;
            }
            cnt++;

            long val = (l.e - cur) / dist;
            cnt += val;
            cur += val * dist;
        }
        return cnt >= n;
    }

    public static long search() {
        long l = 0;
        long r = (long) 1e18;
        long mx = 0;
        while (l <= r) {
            long mid = (l + r) / 2;
            if (possible(mid)) {
                l = mid + 1;
                mx = Math.max(mx, mid);
            } else
                r = mid - 1;
        }
        return mx;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        lines = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            lines.add(new Line(sc.nextLong(), sc.nextLong()));
        }
        Collections.sort(lines, (x, y) -> Long.compare(x.s, y.s));

        System.out.println(search());
    }
}