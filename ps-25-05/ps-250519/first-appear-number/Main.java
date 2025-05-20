// https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-first-appear-number/description

import java.util.Scanner;

public class Main {
    public static int n;
    public static int m;
    public static int[] arr;

    public static int lowerBound(int val) {
        int l = 0, r = n - 1, ans = n - 1;

        while (l <= r) {
            int mid = (l + r) / 2;

            if (val <= arr[mid]) {
                r = mid - 1;
                ans = Math.min(ans, mid);
            } else
                l = mid + 1;
        }
        return val == arr[ans] ? ans : -2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            int ans = lowerBound(sc.nextInt());
            System.out.println(ans + 1);
        }

    }
}