// https://www.codetree.ai/ko/trails/complete/curated-cards/intro-longest-common-sequence/description

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        String B = sc.next();

        int[][] dp = new int[A.length()][B.length()];

        if (A.charAt(0) == B.charAt(0))
            dp[0][0] = 1;
        for (int i = 1; i < A.length(); i++) {
            dp[i][0] = Math.max(dp[i - 1][0], A.charAt(i) == B.charAt(0) ? 1 : 0);
        }
        for (int j = 1; j < B.length(); j++) {
            dp[0][j] = Math.max(dp[0][j - 1], A.charAt(0) == B.charAt(j) ? 1 : 0);
        }
        for (int i = 1; i < A.length(); i++) {
            for (int j = 1; j < B.length(); j++) {
                if (A.charAt(i) == B.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        System.out.println(dp[A.length() - 1][B.length() - 1]);
    }
}