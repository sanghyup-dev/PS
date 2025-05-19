// https://www.codetree.ai/ko/trails/complete/curated-cards/test-subsequence-with-k-or-more-1s/description

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int r = 0;
        int cnt = (arr[0] == 1 ? 1 : 0);
        int min = Integer.MAX_VALUE;

        for (int l = 0; l < n; l++) {
            while (r + 1 < n && cnt < k) {
                if (arr[r + 1] == 1)
                    cnt++;
                r++;
            }
            if (cnt >= k)
                min = Math.min(min, r - l + 1);
            if (arr[l] == 1)
                cnt--;
        }
        System.out.println((min == Integer.MAX_VALUE) ? -1 : min);
    }
}