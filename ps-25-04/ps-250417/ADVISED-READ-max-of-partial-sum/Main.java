// https://www.codetree.ai/ko/trails/complete/curated-cards/intro-max-of-partial-sum/description
// 각 dp칸에 저장되어 있는 정보는 지금까지 중 최고 합이라고 표현하면 부족하다. "그 칸을 마지막 원소"로 하는 "연속적으로 연결된" 집합에서의 최대합으로 봐야한다!
// 추측(불확실): dp 채우기가 더 간편해지지만, 답을 구할때 모든 칸을 고려해야해서 더 복잡.

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int[] dp = new int[n];
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
        }
        int mx = Integer.MIN_VALUE;
        for (int i : dp) {
            mx = Math.max(mx, i);
        }
        System.out.println(mx);
    }
}