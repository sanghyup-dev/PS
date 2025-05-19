// https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-a-group-of-numbers-tied-to-specific-conditions/description

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        Arrays.sort(arr);
        int[] prefixL = new int[n];

        prefixL[0] = 1;
        int e = 0;
        for (int s = 0; s < n; s++) {
            if (e < s) {
                e++;
                prefixL[e] = Math.max(prefixL[e], prefixL[e - 1]);
            }

            while (e + 1 < n && arr[e + 1] - arr[s] <= k) {
                prefixL[e + 1] = e - s + 2;
                if (e > 0)
                    prefixL[e + 1] = Math.max(prefixL[e + 1], prefixL[e]);
                e++;

            }
        }
        int[] prefixR = new int[n];

        prefixR[n - 1] = 1;
        int s = n - 1;
        for (e = n - 1; e >= 0; e--) {
            if (e < s) {
                s--;
                prefixR[s] = Math.max(prefixR[s], prefixR[s + 1]);
            }

            while (s - 1 >= 0 && arr[e] - arr[s - 1] <= k) {
                prefixR[s - 1] = e - s + 2;
                if (s < n - 1)
                    prefixR[s - 1] = Math.max(prefixR[s - 1], prefixR[s]);
                s--;
            }
        }
        int ans = prefixR[0];
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, prefixL[i] + (i + 1 < n ? prefixR[i + 1] : 0));
        }
        System.out.println(ans);
    }
}