// https://www.codetree.ai/ko/trails/complete/curated-cards/intro-sum-of-n-integers-2/description

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] nums = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            nums[i] += nums[i - 1] + sc.nextInt();
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i <= N - K; i++) {
            ans = Math.max(ans, nums[i + K - 1] - nums[i - 1]);
        }
        System.out.println(ans);
    }
}