//https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-minimum-diff-partition/description

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }
        int[] dp = new int[sum + 1];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = -1;
        }
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = dp.length - 1; j > 0; j--) {
                if (j - arr[i] >= 0 && dp[j - arr[i]] != -1) {
                    dp[j] = 1;
                }
            }
        }
        // for (int i : dp) {
        // System.out.print(i + " ");
        // }
        // System.out.println();

        int best = Integer.MAX_VALUE;
        for (int i = 0; i <= sum; i++) {
            if (dp[i] == 1) {
                best = Math.min(best, Math.abs(sum - 2 * i));
            }
        }
        System.out.println(best);

    }
}