//https://www.codetree.ai/ko/trails/complete/curated-cards/intro-coin-change/description
// 동전 순회 -> 가격 순회 와 가격 순회 -> 동전 순회 바꿔도 상관없음.
// 단 한번 씩만 동전 사용 가능: 동전 순회 -> 역순으로 가격 순회!

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] coin = new int[n];
        for (int i = 0; i < n; i++)
            coin[i] = sc.nextInt();
        int[] dp = new int[m + 1];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 0; j < n; j++) {
                if (i >= coin[j]) {
                    if (dp[i - coin[j]] != Integer.MAX_VALUE) {
                        dp[i] = Math.min(dp[i], dp[i - coin[j]] + 1);
                    }
                }
            }
        }
        if (dp[m] == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else
            System.out.println(dp[m]);
    }
}