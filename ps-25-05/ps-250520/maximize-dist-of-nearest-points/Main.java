// https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-maximize-dist-of-nearest-points/description
// insight: 답이 최대 혹은 최소를 구하는 것이라면 parametric search 고려해볼것. 각 케이스마다 답이 쉽게 구해지면 사용

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static class Line {
        int s;
        int e;

        Line(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }

    public static List<Line> lines = new ArrayList<>();

    public static boolean possible(long dist) {
        long cur = Integer.MIN_VALUE;
        for (Line l : lines) {
            if ((cur + dist) < l.s) {
                cur = l.s;
            } else {
                if ((cur + dist) > l.e)
                    return false;
                cur += dist;
            }
        }
        return true;
    }

    public static long search() {
        long l = 0;
        long r = Integer.MAX_VALUE;
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
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            lines.add(new Line(sc.nextInt(), sc.nextInt()));
        }
        Collections.sort(lines, (x, y) -> x.s - y.s);
        System.out.println(search());
    }
}