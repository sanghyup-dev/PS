// https://www.codetree.ai/ko/trails/complete/curated-cards/intro-sum-of-n-integers-3/description

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] arr = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int[][] dp = new int[n + 1][n + 1];
        int ans = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + arr[i][j];
                if (i - k >= 0 && j - k >= 0) {
                    ans = Math.max(ans, dp[i][j] - dp[i - k][j] - dp[i][j - k] + dp[i - k][j - k]);
                }
            }
        }
        System.out.println(ans);
    }
}