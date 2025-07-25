// https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-three-non-adjacent-numbers/description

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] L = new int[n];
        int[] R = new int[n];
        L[0] = arr[0];
        R[n - 1] = arr[n - 1];

        for (int i = 1; i < n; i++) {
            L[i] = Math.max(L[i - 1], arr[i]);
        }
        for (int i = n - 2; i >= 0; i--) {
            R[i] = Math.max(R[i + 1], arr[i]);
        }

        int ans = 0;
        for (int i = 2; i < n - 2; i++) {
            int val = L[i - 2] + R[i + 2] + arr[i];
            ans = Math.max(ans, val);
        }
        System.out.println(ans);
    }
}