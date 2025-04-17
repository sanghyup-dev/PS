//https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-knapsack/description
//dp[0]을 초기화하니까 아무것도 넣지 않은 경우가 자동으로 계산되는 장점이있다.

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] w = new int[n];
        int[] v = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = sc.nextInt();
            v[i] = sc.nextInt();
        }
        int[] dp = new int[m + 1];

        for (int i = 0; i < dp.length; i++) {
            dp[i] = -1;
        }
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = m; j > 0; j--) {
                if (j - w[i] >= 0 && dp[j - w[i]] != -1) {
                    dp[j] = Math.max(dp[j], dp[j - w[i]] + v[i]);
                }
            }
        }
        int mxV = 0;
        for (int i : dp) {
            mxV = Math.max(mxV, i);
        }
        System.out.println(mxV);
    }
}