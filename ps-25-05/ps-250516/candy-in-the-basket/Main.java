// https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-candy-in-the-basket/description

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] line = new int[1_000_002];

        for (int i = 0; i < n; i++) {
            int candy = sc.nextInt();
            int pos = sc.nextInt();
            line[pos] = candy;
        }

        int[] prefixSum = new int[1_000_002];

        prefixSum[0] = line[0];

        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + line[i];
        }

        int end = Math.min(1_000_000, 2 * k);

        long mx = 0;

        for (int i = 0; i < 1_000_001; i++) {
            mx = Math.max(prefixSum[end] - prefixSum[i] + line[i], mx);
            end = Math.min(1_000_000, end + 1);
        }
        System.out.println(mx);
    }
}