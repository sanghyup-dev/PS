// https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-the-number-of-points-within-the-range-2/description

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int q = sc.nextInt();

        boolean[] dots = new boolean[1_000_002];
        for (int i = 0; i < n; i++) {
            dots[sc.nextInt() + 1] = true;
        }

        int[] prefixSum = new int[1_000_002];
        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + (dots[i] ? 1 : 0);
        }

        for (int i = 0; i < q; i++) {
            System.out.println(-(prefixSum[sc.nextInt()] - prefixSum[sc.nextInt() + 1]));
        }
    }
}