//https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-knapsack/description

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] v = new int[n + 1];
        for (int i = 1; i < n; i++) {
            v[i] = sc.nextInt();
        }
        int[] dp = new int[n + 1];

        for (int i = 0; i < dp.length; i++) {
            dp[i] = -1;
        }
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                dp[j] = Math.max(dp[j], dp[j - i] + v[i]);
            }
        }
        System.out.println(dp[n]);
    }
}