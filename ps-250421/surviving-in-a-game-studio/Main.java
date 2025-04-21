//https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-surviving-in-a-game-studio/description

import java.util.Scanner;

public class Main {
    public static final int mod = (int) Math.pow(10, 9) + 7;

    public static int add(int x, int y) {
        return (x % mod + y % mod) % mod;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] dp = new int[n + 1][3];
        dp[0][0] = 1;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < 3; j++) {
                for (int j2 = 1; j2 < 4; j2++) {
                    for (int k = 0; k < 2; k++) {
                        if (i + j2 <= n && j + k <= 2) {
                            dp[i + j2][j + k] = add(dp[i + j2][j + k], dp[i][j]);
                        }
                    }
                }
            }
        }
        int ans = 0;
        for (int i = n; i > n - 3; i--) {
            for (int j = 0; j < 3; j++) {
                if (i >= 0) {
                    ans = add(ans, dp[i][j]);
                }
            }
        }
        System.out.println(ans);
    }
}