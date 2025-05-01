// https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-choose-one-of-two-points/description

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] blue = new int[n * 2 + 1];
        int[] red = new int[n * 2 + 1];

        for (int i = 1; i < red.length; i++) {
            blue[i] = sc.nextInt();
            red[i] = sc.nextInt();
        }

        int[][] dp = new int[2 * n + 1][n + 1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < n + 1; j++) {
                dp[i][j] = Integer.MIN_VALUE;
            }
        }

        dp[0][0] = 0;
        for (int i = 0; i < dp.length - 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                dp[i + 1][j] = Math.max(dp[i + 1][j], dp[i][j] + blue[i + 1]);
                if (j < n) {
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j + 1], dp[i][j] + red[i + 1]);
                }
            }
        }
        System.out.println(dp[2 * n][n]);
    }
}