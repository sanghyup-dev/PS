
//https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-longest-decreasing-subsequence/description
//arr에 있는 value를 DP에 미리 초기화를 해서는 안되는 경우임.

import java.util.Scanner;

public class Main {
    public static int INVALID = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        int[] dp = new int[100001];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = INVALID;
        }

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < arr.length; i++) {
            int j = arr[i];
            dp[j] = 1;
            for (int j2 = j + 1; j2 < dp.length; j2++) {
                if (dp[j2] != INVALID)
                    dp[j] = Math.max(dp[j], dp[j2] + 1);
            }
        }

        int mx = 0;
        for (int i = 0; i < dp.length; i++) {
            mx = Math.max(mx, dp[i]);
        }
        System.out.println(mx);
    }
}
