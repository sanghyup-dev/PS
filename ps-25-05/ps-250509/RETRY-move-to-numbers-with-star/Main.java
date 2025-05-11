// https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-move-to-numbers-with-star/description

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[][] board = new int[n + 1][n + 1]; // 1‑based
        int[][] rowSum = new int[n + 1][n + 1]; // 행별 prefix‑sum

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                board[i][j] = sc.nextInt();
                rowSum[i][j] = rowSum[i][j - 1] + board[i][j];
            }
        }

        int best = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {

                int sum = 0;

                // 위/아래 K칸까지 훑으면서 다이아몬드 폭 계산
                for (int r = i - k; r <= i + k; r++) {
                    if (r < 1 || r > n)
                        continue;

                    int rem = k - Math.abs(r - i); // 가로로 남은 거리
                    int left = Math.max(1, j - rem);
                    int right = Math.min(n, j + rem);

                    sum += rowSum[r][right] - rowSum[r][left - 1];
                }
                best = Math.max(best, sum);
            }
        }
        System.out.println(best);
    }
}
