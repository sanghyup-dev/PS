// https://www.codetree.ai/ko/trails/complete/curated-cards/test-soccer-and-baseball/description

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] soccer = new int[N];
        int[] baseball = new int[N];
        for (int i = 0; i < N; i++) {
            soccer[i] = sc.nextInt();
            baseball[i] = sc.nextInt();
        }
        int[][][] dp = new int[N + 1][12][10];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < 12; j++) {
                for (int j2 = 0; j2 < 10; j2++) {
                    dp[i][j][j2] = Integer.MIN_VALUE;
                }
            }
        }

        dp[0][0][0] = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 12; j++) {
                for (int j2 = 0; j2 < 10; j2++) {
                    if (dp[i][j][j2] != Integer.MIN_VALUE) {
                        dp[i + 1][j][j2] = Math.max(dp[i + 1][j][j2], dp[i][j][j2]);
                        if (j < 11) {
                            dp[i + 1][j + 1][j2] = Math.max(dp[i + 1][j + 1][j2], dp[i][j][j2] + soccer[i]);
                        }
                        if (j2 < 9) {
                            dp[i + 1][j][j2 + 1] = Math.max(dp[i + 1][j][j2 + 1], dp[i][j][j2] + baseball[i]);
                        }
                    }
                }
            }
        }
        System.out.println(dp[N][11][9]);
    }
}