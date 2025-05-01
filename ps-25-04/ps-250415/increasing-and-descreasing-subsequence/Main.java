//https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-increasing-and-descreasing-subsequence/description

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] dpUp = new int[n];
        int[] dpDown = new int[n];

        dpUp[0] = 1;
        for (int i = 1; i < n; i++) {
            dpUp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dpUp[i] = Math.max(dpUp[i], dpUp[j] + 1);
                }
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (arr[j] < arr[i]) {
                    dpDown[i] = Math.max(dpDown[i], dpDown[j] + 1);
                }
            }
        }

        int mx = 0;
        for (int i = 0; i < n; i++) {
            mx = Math.max(mx, dpUp[i] + dpDown[i]);
        }
        System.out.println(mx);
    }
}