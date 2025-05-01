//https://www.codetree.ai/ko/trails/complete/curated-cards/test-equal-partition/description
//이 문제처럼 결과 여러군데서 처리하다 실수하지말고 그냥 마지막에 처리하자. 어차피 다 계산해도 시간제한에 안 걸릴게 뻔하니까.

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
        if (sum % 2 != 0) {
            System.out.println("No");
            return;
        }
        boolean[] dp = new boolean[sum];
        dp[0] = true;

        for (int i = 0; i < n; i++) {
            for (int j = dp.length - 1; j >= arr[i]; j--) {
                if (dp[j - arr[i]]) {
                    dp[j] = true;
                }
            }
        }
        if (dp[sum / 2])
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}