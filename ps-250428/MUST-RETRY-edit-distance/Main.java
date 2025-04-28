// https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-edit-distance/description
// 이걸 떠올릴 수 있을까? 흠.. x축 y축으로 둘다 이동하니까 모든 경우가 고려가 된다?

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        String B = sc.next();

        int[][] dp = new int[A.length() + 1][B.length() + 1];

        for (int i = 0; i < A.length() + 1; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i < B.length() + 1; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= A.length(); i++) {
            for (int j = 1; j <= B.length(); j++) {
                dp[i][j] = Integer.MAX_VALUE;

            }
        }

        for (int i = 1; i <= A.length(); i++) {
            for (int j = 1; j <= B.length(); j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1))
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
                else {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 1);
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + 1);
                }
            }
        }
        // for (int[] is : dp) {
        // for (int i : is) {
        // System.out.print(i + " ");
        // }
        // System.out.println();
        // }
        System.out.println(dp[A.length()][B.length()]);
    }
}