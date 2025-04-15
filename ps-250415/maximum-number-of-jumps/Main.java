//https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-maximum-number-of-jumps/description
//왜 초기화를 안일하게 0으로 놔두면 안되는지 보여주는 문제(한번도 도달하지 않은 위치는 넘어가야함)

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] dp = new int[n];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = Integer.MIN_VALUE;
        }
        dp[0] = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == Integer.MIN_VALUE)
                continue;
            int j = Math.min(n, i + arr[i] + 1);
            for (int j2 = i + 1; j2 < j; j2++) {
                dp[j2] = Math.max(dp[j2], dp[i] + 1);
            }
        }
        int mx = 0;
        for (int i = 0; i < dp.length; i++) {
            mx = Math.max(mx, dp[i]);
        }
        System.out.println(mx);
    }
}
