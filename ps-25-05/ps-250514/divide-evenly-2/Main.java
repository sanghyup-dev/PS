// https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-divide-evenly-2/descriptionimport java.util.Scanner;

import java.util.Scanner;

public class Main {
    public static int[][] prefixSum;

    public static int getDots(int x1, int y1, int x2, int y2) {
        return prefixSum[x2][y2] - prefixSum[x2][y1 - 1] - prefixSum[x1 - 1][y2] + prefixSum[x1 - 1][y1 - 1];
    }

    public static int getMax(int x, int y) {
        int max = 0;
        max = Math.max(max, getDots(1, 1, x, y));
        max = Math.max(max, getDots(x + 1, 1, 500, y));
        max = Math.max(max, getDots(1, y + 1, x, 500));
        max = Math.max(max, getDots(x + 1, y + 1, 500, 500));
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] grid = new int[502][502];
        for (int i = 0; i < n; i++) {
            grid[sc.nextInt() / 2 + 1][sc.nextInt() / 2 + 1] = 1;
        }

        prefixSum = new int[501][501];

        for (int i = 1; i < 501; i++) {
            for (int j = 1; j < 501; j++) {
                prefixSum[i][j] = prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1] + grid[i][j];
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < 501; i++) {
            for (int j = 1; j < 501; j++) {
                min = Math.min(min, getMax(i, j));
            }
        }
        System.out.println(min);
    }
}