//https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-right-equality/description

import java.util.Scanner;

public class Main {
    public static final int OFFSET = 20;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        long[][] dp = new long[N + 1][20 + 1 + OFFSET];

        dp[0][0 + OFFSET] = 1;

        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            for (int j = 0; j < 21 + OFFSET; j++) {
                if (dp[i][j] != 0) {
                    if (j - num >= 0)
                        dp[i + 1][j - num] += dp[i][j];
                    if (j + num < 21 + OFFSET)
                        dp[i + 1][j + num] += dp[i][j];
                }
            }
        }
        System.out.println(dp[N][M + OFFSET]);

    }
}