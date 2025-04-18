// https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-number-war/description

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }
        int[][] dp = new int[n + 1][n + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        dp[0][0] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] == -1)
                    continue;
                dp[i + 1][j + 1] = Math.max(dp[i + 1][j + 1], dp[i][j]);
                if (b[i] < a[j])
                    dp[i + 1][j] = Math.max(dp[i + 1][j], dp[i][j] + b[i]);
                if (b[i] > a[j])
                    dp[i][j + 1] = Math.max(dp[i][j + 1], dp[i][j]);
            }
        }

        int mx = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                mx = Math.max(dp[i][j], mx);
            }
        }
        System.out.println(mx);
    }
}