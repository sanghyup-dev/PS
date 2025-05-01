//https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-explore-temple/description

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] data = new int[N][3];
        for (int i = 0; i < N; i++) {
            data[i][0] = sc.nextInt();
            data[i][1] = sc.nextInt();
            data[i][2] = sc.nextInt();
        }
        int[][] dp = new int[N][3];

        for (int i = 0; i < 3; i++) {
            dp[0][i] = data[0][i];
        }
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < 3; j++) {
                for (int j2 = 0; j2 < 3; j2++) {
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