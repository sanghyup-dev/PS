// https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-the-sum-of-the-subsequences-is-k/description

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] PrefixSum = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            PrefixSum[i] = PrefixSum[i - 1] + sc.nextInt();
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (PrefixSum[i] - PrefixSum[j] == k)
                    ans++;

            }
        }
        System.out.println(ans);
    }
}