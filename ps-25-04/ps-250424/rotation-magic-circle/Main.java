// https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-rotation-magic-circle/description

import java.util.Scanner;

public class Main {
    public static final int LEFT = 1;
    public static final int RIGHT = -1;

    public static int turn(int x, int amount, int dir) {
        return (x + amount * dir + 10) % 10;
    }

    public static int match(int s, int t, int curLefts, int targLefts) {
        int lefts = curLefts <= targLefts ? targLefts - curLefts : targLefts + 10 - curLefts;
        s = turn(s, targLefts, LEFT);
        int turns = s - t + lefts;
        if (s < t)
            turns += 10;
        return turns;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String current = sc.next();
        String target = sc.next();

        int[][] dp = new int[n][10];
        for (int i = 0; i < 10; i++) {
            dp[0][i] = match(current.charAt(0) - '0', target.charAt(0) - '0', 0, i);
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 10; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 1; i < n; i++) { // 단계
            for (int j = 0; j < 10; j++) { // 현단계 좌회전
                for (int j2 = 0; j2 < 10; j2++) { // 전단계 좌회전
                    dp[i][j] = Math.min(dp[i][j],
                            dp[i - 1][j2] + match(current.charAt(i) - '0', target.charAt(i) - '0', j2, j));
                }
            }
        }
        // for (int[] is : dp) {
        // for (int i : is) {
        // System.out.print(i + " ");
        // }
        // System.out.println();
        // }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            ans = Math.min(ans, dp[n - 1][i]);
        }
        System.out.println(ans);

    }
}