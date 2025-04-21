//https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-select-m-sections/description
//함부로 Integer.MIN_VALUE 쓰고 방치하다가 언더플로우 당함. 늘 초기값 신경쓰기.

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[][] dp = new int[n][2 * m + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < 2 * m + 1; j++) {
                dp[i][j] = -1000002;
            }
        }

        for (int i = 0; i < n; i++) {
            dp[i][0] = 0;
        }
        dp[0][1] = arr[0];

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < 2 * m + 1; j++) {
                if (j % 2 == 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1]);
                } else {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j] + arr[i]);
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + arr[i]);
                }
            }
        }
        System.out.println(Math.max(dp[n - 1][2 * m - 1], dp[n - 1][2 * m]));
    }
}