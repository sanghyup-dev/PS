// https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-sum-closest-to-zero/description
// hint(보지말고 풀기): 항상 양수음수 쌍이 최적이 아님...

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextLong();

        Arrays.sort(a); // O(N log N)

        int l = 0, r = n - 1;
        long best = Long.MAX_VALUE; // current best |sum|

        while (l < r) { // O(N)
            long s = a[l] + a[r];
            best = Math.min(best, Math.abs(s));

            if (s == 0)
                break; // perfect
            if (s < 0)
                l++; // need a larger sum
            else
                r--; // need a smaller sum
        }
        System.out.println(best);
    }
}
