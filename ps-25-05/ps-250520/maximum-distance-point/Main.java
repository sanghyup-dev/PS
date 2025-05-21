// https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-maximum-distance-point/description

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static int n;
    public static int m;
    public static int[] points;

    public static boolean possible(int val) {
        int cnt = 1;
        int len = 0;
        for (int i = 1; i < points.length; i++) {
            len += points[i] - points[i - 1];
            if (len >= val) {
                cnt++;
                len = 0;
            }
        }
        return cnt >= m;
    }

    public static int search() {
        int l = 0, r = 1_000_000_000, mx = 0;
        while (l <= r) {
            int mid = (l + r) / 2;
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
        points = new int[n];
        for (int i = 0; i < n; i++) {
            points[i] = sc.nextInt();
        }
        Arrays.sort(points);

        System.out.println(search());
    }
}