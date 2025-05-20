// https://www.codetree.ai/ko/trails/complete/curated-cards/intro-number-of-integers/descriptions

import java.util.Scanner;

public class Main {
    public static int n;
    public static int m;
    public static int[] arr;

    public static int lowerBound(int val) {
        int l = 0;
        int r = n - 1;
        int ans = n;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] >= val) {
                r = mid - 1;
                ans = Math.min(ans, mid);
            } else
                l = mid + 1;
        }
        return ans;
    }

    public static int upperBound(int val) {
        int l = 0;
        int r = n - 1;
        int ans = n;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] > val) {
                r = mid - 1;
                ans = Math.min(ans, mid);
            } else
                l = mid + 1;
        }
        return ans;
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
            int x = sc.nextInt();
            System.out.println(upperBound(x) - lowerBound(x));
        }
    }
}