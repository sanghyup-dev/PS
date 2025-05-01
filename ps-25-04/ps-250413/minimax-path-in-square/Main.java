// https://www.codetree.ai/ko/trails/complete/curated-cards/test-minimax-path-in-square/description

import java.util.Scanner;

public class Main {
    public static int n;
    public static int[][] matrix;
    public static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        matrix = new int[n][n];
        dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        dp[0][0] = matrix[0][0];
        for (int i = 1; i < n; i++) {
            dp[0][i] = Math.max(dp[0][i - 1], matrix[0][i]);
            dp[i][0] = Math.max(dp[i - 1][0], matrix[i][0]);
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(Math.min(dp[i][j - 1], dp[i - 1][j]), matrix[i][j]);
            }
        }
        System.out.println(dp[n - 1][n - 1]);
    }
}