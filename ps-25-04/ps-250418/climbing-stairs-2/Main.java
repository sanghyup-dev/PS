//https://www.codetree.ai/ko/trails/complete/curated-cards/intro-climbing-stairs-2/description

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] coins = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            coins[i] = sc.nextInt();
        }
        int dp[][] = new int[n + 1][4];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < 4; j++) {
                dp[i][j] = Integer.MIN_VALUE;
            }
        }
        dp[0][0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 4; j++) {
                if (i - 2 >= 0)
                    dp[i][j] = Math.max(dp[i][j], dp[i - 2][j] + coins[i]);
                if (j > 0)
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + coins[i]);
            }
        }
        int mx = Integer.MIN_VALUE;

        for (int i = 0; i < 4; i++) {
            mx = Math.max(dp[n][i], mx);
        }
        System.out.println(mx);
    }
}