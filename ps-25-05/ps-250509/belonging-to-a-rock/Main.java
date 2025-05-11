// https://www.codetree.ai/ko/trails/complete/curated-cards/test-belonging-to-a-rock/description

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int q = sc.nextInt();

        int[][] prefixSum = new int[n + 1][4];

        for (int i = 1; i <= n; i++) {
            int num = sc.nextInt();
            for (int j = 1; j <= 3; j++) {
                prefixSum[i][j] = prefixSum[i - 1][j];
            }
            prefixSum[i][num] += 1;
        }

        for (int i = 0; i < q; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            for (int j = 1; j <= 3; j++) {
                System.out.print((-prefixSum[s - 1][j] + prefixSum[e][j]) + " ");
            }
            System.out.println();
        }
    }
}