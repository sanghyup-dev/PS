// https://www.codetree.ai/ko/trails/complete/curated-cards/test-shortest-common-supersubsequence/description
// 어느정도 써도되는 것 같은 직관: 우리는 글자하나를 추가한다. 그 글자는 s 또는 t중 하나이다. 따라서 우리는 둘중 어느 문자열에서 단 하나의 글자를 추가하는 모든 경우를 고려하면 답이 나온다.

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= t.length(); i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j < t.length(); j++) {
                dp[i][j] = Integer.MAX_VALUE;

            }
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                }
            }
        }
        System.out.println(dp[s.length()][t.length()]);
    }
}