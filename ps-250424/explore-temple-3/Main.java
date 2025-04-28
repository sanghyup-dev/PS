//https://www.codetree.ai/ko/trails/complete/curated-cards/test-explore-temple-M/description

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] data = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                data[i][j] = sc.nextInt();
            }
        }
        int[][] dp = new int[N][M];

        for (int i = 0; i < M; i++) {
            dp[0][i] = data[0][i];
        }
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < M; j++) {
                for (int j2 = 0; j2 < M; j2++) {
                    if (j != j2) {
                        dp[i + 1][j] = Math.max(dp[i + 1][j], dp[i][j2] + data[i + 1][j]);
                    }
                }
            }
        }
        int mx = 0;

        for (int i : dp[N - 1]) {
            mx = Math.max(mx, i);
        }
        System.out.println(mx);
    }
}