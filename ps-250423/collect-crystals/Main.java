//https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-collect-crystals/description

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        String s = sc.next();
        int[] crystals = new int[N];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L') {
                crystals[i] = 0;
            } else {
                crystals[i] = 1;
            }
        }

        int[][] dp = new int[N][K + 1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < K + 1; j++) {
                dp[i][j] = Integer.MIN_VALUE;
            }
        }

        if (crystals[0] == 1) {
            dp[0][1] = 1;
            dp[0][0] = 0;
        } else {
            dp[0][1] = 0;
            dp[0][0] = 1;
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < K + 1; j++) {
                if (dp[i - 1][j] != Integer.MIN_VALUE) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j] + ((j % 2 == crystals[i]) ? 1 : 0));
                }
                if (j - 1 >= 0 && dp[i - 1][j - 1] != Integer.MIN_VALUE) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + ((j % 2 == crystals[i]) ? 1 : 0));
                }
            }
        }

        int mx = 0;

        for (int i = 0; i < K + 1; i++) {
            mx = Math.max(mx, dp[N - 1][i]);
        }
        System.out.println(mx);
    }
}