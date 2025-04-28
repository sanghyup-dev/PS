// https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-longest-common-sequence-2/description
// 아래처럼 바로 String을 짜는 경우와 경로만 짜놓고 역순으로 String을 구성하는 경우의 장점을 생각해보세요.
// Main 2 참고. -> 시간 공간 복잡도 부분에서 Main2가 유리하다.

import java.util.Scanner;

public class Main {

    public static class Case {
        int n = 0;
        String s = "";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        String B = sc.next();

        Case[][] dp = new Case[A.length()][B.length()];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < B.length(); j++) {
                dp[i][j] = new Case();
            }
        }
        if (A.charAt(0) == B.charAt(0)) {
            dp[0][0].n = 1;
            dp[0][0].s = "" + A.charAt(0);
        } else {
            dp[0][0].n = 0;
            dp[0][0].s = "";
        }

        for (int i = 1; i < A.length(); i++) {
            dp[i][0].n = Math.max(dp[i - 1][0].n, A.charAt(i) == B.charAt(0) ? 1 : 0);
            if (dp[i][0].n == 1) {
                dp[i][0].s = "" + B.charAt(0);
            }
        }
        for (int j = 1; j < B.length(); j++) {
            dp[0][j].n = Math.max(dp[0][j - 1].n, A.charAt(0) == B.charAt(j) ? 1 : 0);
            if (dp[0][j].n == 1) {
                dp[0][j].s = "" + A.charAt(0);
            }
        }
        for (int i = 1; i < A.length(); i++) {
            for (int j = 1; j < B.length(); j++) {
                if (A.charAt(i) == B.charAt(j)) {
                    dp[i][j].n = dp[i - 1][j - 1].n + 1;
                    dp[i][j].s = new String(dp[i - 1][j - 1].s) + A.charAt(i);
                } else {
                    dp[i][j].n = Math.max(dp[i - 1][j].n, dp[i][j - 1].n);
                    if (dp[i][j].n == dp[i - 1][j].n) {
                        dp[i][j].s = new String(dp[i - 1][j].s);
                    } else {
                        dp[i][j].s = new String(dp[i][j - 1].s);
                    }
                }
            }
        }
        System.out.println(dp[A.length() - 1][B.length() - 1].s);
    }
}