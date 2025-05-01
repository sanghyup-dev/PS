//https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-stair-number/description

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] dp = new int[n][10];
        for (int i = 1; i < 10; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < 10; j++) {
                if (j - 1 >= 0) {
                    dp[i][j] += dp[i - 1][j - 1];
                    dp[i][j] %= 1_000_000_007;
                }
                if (j + 1 < 10) {
                    dp[i][j] += dp[i - 1][j + 1];
                    dp[i][j] %= 1_000_000_007;
                }
            }
        }

        int sm = 0;
        for (int i = 0; i < 10; i++) {
            sm += dp[n - 1][i];
            sm %= 1_000_000_007;
        }
        System.out.println(sm);
    }
}