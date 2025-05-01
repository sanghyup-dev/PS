// https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-secret-of-ancient-treasure-map/description

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        int[][] dp = new int[N + 1][K + 1];

        for (int i = 0; i < N; i++) {
            for (int j = 1; j <= K; j++) {
                dp[i][j] = -Integer.MIN_VALUE;
            }
        }
        for (int i = 0; i < N; i++) {
            dp[i][0] = arr[i];
        }
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j <= K; j++) {
                if (dp[i][j] == Integer.MIN_VALUE)
                    continue;
                if (arr[i + 1] < 0) {
                    if (j != K)
                        dp[i + 1][j + 1] = Math.max(dp[i + 1][j + 1], dp[i][j] + arr[i + 1]);
                } else {
                    dp[i + 1][j] = Math.max(dp[i + 1][j], dp[i][j] + arr[i + 1]);
                }
            }
        }
        int mx = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= K; j++) {
                mx = Math.max(mx, dp[i][j]);
            }
        }
        System.out.println(mx);
    }
}