// https://www.codetree.ai/ko/trails/complete/curated-cards/test-the-sum-of-the-numbers-is-a-multiple-of-7/description

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int[] prefix = new int[n];

        prefix[0] = nums[0] % 7;

        for (int i = 1; i < n; i++) {
            prefix[i] = (prefix[i - 1] + nums[i]) % 7;
        }

        int ans = 0;

        for (int i = 0; i < 7; i++) {
            int first = -1;
            int last = -1;

            for (int j = 0; j < n; j++) {
                if (first == -1 && prefix[j] == i) {
                    first = j;
                }
                if (prefix[j] == i)
                    last = j;
            }
            ans = Math.max(ans, last - first);
        }
        System.out.println(ans);
    }
}