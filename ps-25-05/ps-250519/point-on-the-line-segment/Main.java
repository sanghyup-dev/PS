// https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-point-on-the-line-segment/description

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static int lowerBound(int val, int n, int[] points) {
        int l = 0, r = n - 1, ans = n;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (val <= points[mid]) {
                r = mid - 1;
                ans = Math.min(ans, mid);
            } else
                l = mid + 1;
        }

        return ans;
    }

    public static int customBound(int val, int n, int[] points) {
        int l = 0, r = n - 1, ans = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (val >= points[mid]) {
                l = mid + 1;
                ans = Math.max(ans, mid);
            } else
                r = mid - 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] points = new int[n];
        for (int i = 0; i < n; i++) {
            points[i] = sc.nextInt();
        }

        Arrays.sort(points);

        int a, b;
        for (int i = 0; i < m; i++) {
            a = sc.nextInt();
            b = sc.nextInt();

            int lIdx = lowerBound(a, n, points);
            int rIdx = customBound(b, n, points);

            if (lIdx >= 0 && rIdx < n && rIdx >= lIdx) {
                System.out.println(rIdx - lIdx + 1);
            } else
                System.out.println(0);
        }
    }
}