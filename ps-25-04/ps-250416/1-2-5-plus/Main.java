//https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-1-2-5-plus/description

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] nums = { 1, 2, 5 };
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int j = 1; j < dp.length; j++) {
            for (int i = 0; i < nums.length; i++) {
                if (j - nums[i] >= 0) {
                    dp[j] += (dp[j - nums[i]]) % 10007;
                }
            }
        }
        System.out.println(dp[n] % 10007);
    }
}