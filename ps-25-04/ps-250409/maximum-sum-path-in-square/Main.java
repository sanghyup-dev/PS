//https://www.codetree.ai/ko/trails/complete/curated-cards/intro-maximum-sum-path-in-square/description

import java.util.Scanner;

public class Main {

    public static int n;
    public static int[][] matrix;
    public static int[][] max;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        matrix = new int[n][n];
        max = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        max[0][0] = matrix[0][0];
        for (int i = 1; i < n; i++) {
            max[i][0] = max[i - 1][0] + matrix[i][0];
        }
        for (int i = 1; i < n; i++) {
            max[0][i] = max[0][i - 1] + matrix[0][i];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                max[i][j] = Math.max(max[i - 1][j], max[i][j - 1]) + matrix[i][j];
            }
        }
        System.out.println(max[n - 1][n - 1]);

    }
}