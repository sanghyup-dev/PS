//https://www.codetree.ai/ko/trails/complete/curated-cards/intro-select-proper-clothes/description

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] basic = new int[m][n];

        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            int v = sc.nextInt();

            for (int j = s - 1; j < e; j++) {
                basic[j][i] = v;
            }
        }

        int[][] dp = new int[m][n];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < n; j++) {
                if (basic[i][j] != 0) {
                    for (int j2 = 0; j2 < n; j2++) {
                        if (basic[i - 1][j2] != 0)
                            dp[i][j] = Math.max(dp[i][j], dp[i - 1][j2] + Math.abs(basic[i][j] - basic[i - 1][j2]));
                    }
                }
            }
        }
        int mx = 0;

        for (int i = 0; i < n; i++) {
            mx = Math.max(mx, dp[m - 1][i]);
        }
        System.out.println(mx);
    }
}