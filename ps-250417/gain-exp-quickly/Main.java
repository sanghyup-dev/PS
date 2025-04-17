// https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-gain-exp-quickly/description
// 이런 knapsack문제의 경우 dp iteration마다 뒤를 검사하는 것이 아니라 조건에 해당할 때마다 뒤 dp를 수정하는 방식도 가능하다.
// exp의 마지막을 특정하기 어렵기에 시작점으로 dp를 진행함! (line 25~35 참조조)
// knapsack응용문제 생각흐름 : 물건 넣고 뺄때 조건에 대한 모든 경우의 수에 대해 이차원 DP

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] exp = new int[n];
        int[] time = new int[n];
        for (int i = 0; i < n; i++) {
            exp[i] = sc.nextInt();
            time[i] = sc.nextInt();
        }
        int[] dp = new int[m + 1];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < n; i++) {
            for (int j = m; j >= m - exp[i]; j--) {
                if (dp[j] != Integer.MAX_VALUE) {
                    dp[m] = Math.min(dp[m], dp[j] + time[i]);
                }
            }

            for (int j = m - exp[i] - 1; j >= 0; j--) {
                if (dp[j] != Integer.MAX_VALUE) {
                    dp[j + exp[i]] = Math.min(dp[j + exp[i]], dp[j] + time[i]);
                }
            }
        }
        if (dp[m] == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else
            System.out.println(dp[m]);
    }
}