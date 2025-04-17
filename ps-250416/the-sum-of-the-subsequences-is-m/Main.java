//https://www.codetree.ai/ko/trails/complete/curated-cards/intro-the-sum-of-the-subsequences-is-m/description
// 수정하는 칸이 이동할 때 내가 수정한 것이 다음 수정의 '시야'에 없도록 하자. '시야' 수정에 고려해야하는 요소들
// 내가 정의한 문제를 해결하기 어려울 때는 문제 자체를 없앨 수 있는 방법도 고민해보자.

import java.util.Scanner;

public class Main {
    public static final int MAX = 1000001;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] dp = new int[m + 1];

        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = MAX;
        }

        for (int i = 0; i < n; i++) {
            for (int j = m; j >= 0; j--) {
                if (j - arr[i] >= 0 && dp[j - arr[i]] != MAX) {
                    dp[j] = Math.min(dp[j], dp[j - arr[i]] + 1);
                }
            }
        }
        if (dp[m] == MAX) {
            System.out.println(-1);
        } else
            System.out.println(dp[m]);
    }
}