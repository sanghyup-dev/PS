//https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-longest-increasing-sequence-2d/description

import java.util.Scanner;

public class Main {

    public static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][m];
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                grid[i][j] = sc.nextInt();
        dp[0][0] = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (grid[i][j] > grid[0][0]) {
                    dp[i][j] = 2;
                }
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (dp[i][j] != 0) {
                    for (int j2 = i + 1; j2 < n; j2++) {
                        for (int k = j + 1; k < m; k++) {
                            if (grid[j2][k] > grid[i][j]) {
                                dp[j2][k] = Math.max(dp[j2][k], dp[i][j] + 1);
                            }
                        }
                    }
                }
            }
        }
        int mx = 0;
        for (int[] is : dp) {
            for (int i : is) {
                mx = Math.max(mx, i);
            }
        }
        System.out.println(mx);
    }
}