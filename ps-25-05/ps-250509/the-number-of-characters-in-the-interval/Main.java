// https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-the-number-of-characters-in-the-interval/description

import java.util.Scanner;

public class Main {

    public static int find(int[][] sums, int r1, int c1, int r2, int c2) {
        return sums[r2][c2] - sums[r2][c1 - 1] - sums[r1 - 1][c2] + sums[r1 - 1][c1 - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        int[][] sumA = new int[n + 1][m + 1];
        int[][] sumB = new int[n + 1][m + 1];
        int[][] sumC = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            String s = " " + sc.next();
            for (int j = 1; j <= m; j++) {
                sumA[i][j] = sumA[i][j - 1] + sumA[i - 1][j] - sumA[i - 1][j - 1] + (s.charAt(j) == 'a' ? 1 : 0);
                sumB[i][j] = sumB[i][j - 1] + sumB[i - 1][j] - sumB[i - 1][j - 1] + (s.charAt(j) == 'b' ? 1 : 0);
                sumC[i][j] = sumC[i][j - 1] + sumC[i - 1][j] - sumC[i - 1][j - 1] + (s.charAt(j) == 'c' ? 1 : 0);
            }
        }

        for (int i = 0; i < k; i++) {
            int r1 = sc.nextInt();
            int c1 = sc.nextInt();
            int r2 = sc.nextInt();
            int c2 = sc.nextInt();
            System.out.print(find(sumA, r1, c1, r2, c2) + " ");
            System.out.print(find(sumB, r1, c1, r2, c2) + " ");
            System.out.print(find(sumC, r1, c1, r2, c2) + " ");
            System.out.println();
        }

    }
}