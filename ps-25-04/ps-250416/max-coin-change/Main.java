//https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-max-coin-change/description

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] coin = new int[n];
        for (int i = 0; i < n; i++) {
            coin[i] = sc.nextInt();
        }

        int[] dp = new int[m + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = -1;
        }
        dp[0] = 0;
        for (int i = 0; i < coin.length; i++) {
            for (int j = 1; j < dp.length; j++) {
                if (j - coin[i] >= 0 && dp[j - coin[i]] != -1) {
                    dp[j] = Math.max(dp[j], dp[j - coin[i]] + 1);
                }
            }
        }
        System.out.println(dp[m]);
    }
}