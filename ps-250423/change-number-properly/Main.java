//https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-change-number-properly/description

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] seq = new int[N];
        for (int i = 0; i < N; i++) {
            seq[i] = sc.nextInt();
        }
        int[][][] dp = new int[N][5][M + 1];
        dp[0][seq[0]][0] = 1;

        for (int i = 0; i < N - 1; i++) {
            for (int j = 1; j < 5; j++) {
                for (int k = 0; k < M + 1; k++) {
                    for (int j2 = 1; j2 < 5; j2++) {
                        if (j == j2) {
                            dp[i + 1][j2][k] = Math.max(dp[i + 1][j2][k], dp[i][j][k] + ((j2 == seq[i + 1]) ? 1 : 0));
                        } else {
                            if (k < M) {
                                dp[i + 1][j2][k + 1] = Math.max(dp[i + 1][j2][k + 1],
                                        dp[i][j][k] + ((j2 == seq[i + 1]) ? 1 : 0));
                            }
                        }
                    }
                }
            }
        }
        int mx = 0;
        for (int i = 1; i < 5; i++) {
            for (int j = 0; j < M + 1; j++) {
                mx = Math.max(mx, dp[N - 1][i][j]);
            }
        }
        System.out.println(mx);
    }
}