//https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-the-sum-of-the-subsequences/descriptions

import java.util.Scanner;

public class Main {
    public static final int MAX = 1000001;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] dp = new int[m + 1];

        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = MAX;
        }

        for (int i = 0; i < n; i++) {
            for (int j = m; j >= 0; j--) {
                if (j - arr[i] >= 0 && dp[j - arr[i]] != MAX) {
                    dp[j] = Math.min(dp[j], dp[j - arr[i]] + 1);
                }
            }
        }
        if (dp[m] == MAX) {
            System.out.println("No");
        } else
            System.out.println("Yes");
    }
}