
// /https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-minimum-sum-path-in-square/description
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                matrix[i][j] = sc.nextInt();

        int[][] min = new int[n][n];

        min[0][n - 1] = matrix[0][n - 1];
        for (int i = n - 2; i >= 0; i--) {
            min[0][i] = min[0][i + 1] + matrix[0][i];
        }
        for (int i = 1; i < n; i++) {
            min[i][n - 1] = min[i - 1][n - 1] + matrix[i][n - 1];
        }

        for (int i = 1; i < n; i++) {
            for (int j = n - 2; j >= 0; j--) {
                min[i][j] = Math.min(min[i][j + 1], min[i - 1][j]) + matrix[i][j];
            }
        }

        System.out.println(min[n - 1][0]);
    }
}