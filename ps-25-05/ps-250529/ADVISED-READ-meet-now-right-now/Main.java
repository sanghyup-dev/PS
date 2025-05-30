// https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-meet-now-right-now/description
// 실수형 이진탐색 -> 근사치 구하기

import java.util.Scanner;

public class Main {

    public static class Range {
        double s;
        double e;

        Range(double s, double e) {
            this.s = s;
            this.e = e;
        }
    }

    public static boolean possible(double t) {
        Range canMeet = new Range(x[0] - v[0] * t, x[0] + v[0] * t);
        for (int i = 1; i < n; i++) {
            canMeet.s = Math.max(canMeet.s, x[i] - v[i] * t);
            canMeet.e = Math.min(canMeet.e, x[i] + v[i] * t);
            if (canMeet.s > canMeet.e)
                return false;
        }
        return true;
    }

    public static double pSearch() {
        double l = 0, r = 1e9 + 1, mn = r + 1;
        int iter = 100;
        while (iter-- > 0) {
            double mid = (l + r) / 2;
            if (possible(mid)) {
                r = mid;
                mn = Math.min(mn, mid);
            } else
                l = mid;
        }
        return mn;
    }

    public static int[] x;
    public static int[] v;
    public static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        x = new int[n];
        v = new int[n];
        for (int i = 0; i < n; i++)
            x[i] = sc.nextInt();
        for (int i = 0; i < n; i++)
            v[i] = sc.nextInt();
        double ans = pSearch();
        System.out.printf("%.4f", ans);
    }
}