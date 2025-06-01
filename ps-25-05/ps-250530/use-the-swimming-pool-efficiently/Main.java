// https://www.codetree.ai/ko/trails/complete/curated-cards/test-use-the-swimming-pool-efficiently/description

import java.util.Scanner;

public class Main {

    public static boolean isPossible(int t, int m, int[] arr) {
        int cur = 0;
        int lanes = 1;
        for (int useT : arr) {
            if (useT > t)
                return false;
            if (cur + useT > t) {
                lanes++;
                cur = useT;
            } else
                cur += useT;
        }
        return lanes <= m;
    }

    public static int pSearch(int m, int[] arr) {
        int l = 0, r = 144_000_001, mn = r + 1;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (isPossible(mid, m, arr)) {
                r = mid - 1;
                mn = Math.min(mn, mid);
            } else
                l = mid + 1;
        }
        return mn;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(pSearch(m, arr));
    }
}