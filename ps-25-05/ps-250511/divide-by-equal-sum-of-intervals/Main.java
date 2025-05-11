// https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-divide-by-equal-sum-of-intervals/description

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] arr = new long[n];
        long total = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
            total += arr[i];
        }

        if (total % 4 != 0) {
            System.out.println(0);
            return;
        }

        long[] nL = new long[n];
        long[] nR = new long[n];
        nL[0] = arr[0];
        nR[n - 1] = arr[n - 1];

        for (int i = 1; i < n; i++) {
            nL[i] = nL[i - 1] + arr[i];
        }
        for (int i = n - 2; i >= 0; i--) {
            nR[i] = nR[i + 1] + arr[i];
        }
        int[] first = new int[n];
        int[] last = new int[n];

        first[0] = ((nL[0] == (total / 4)) ? 1 : 0);
        last[n - 1] = ((nR[n - 1] == (total / 4)) ? 1 : 0);

        for (int i = 1; i < n; i++) {
            first[i] = first[i - 1] + ((nL[i] == (total / 4)) ? 1 : 0);
        }
        for (int i = n - 2; i >= 0; i--) {
            last[i] = last[i + 1] + ((nR[i] == (total / 4)) ? 1 : 0);
        }

        long ans = 0;
        for (int i = 1; i < n - 2; i++) {
            if ((nL[i] == (total / 2)) && (nR[i + 1] == (total / 2))) {
                ans += first[i - 1] * last[i + 2];
            }
        }
        System.out.println(ans);
    }
}