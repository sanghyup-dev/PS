// https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-max-profit-of-single-car-2/description

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] prices = new int[n];
        for (int i = 0; i < n; i++)
            prices[i] = sc.nextInt();
        int[] lprefix = new int[n];
        lprefix[0] = prices[0];
        for (int i = 1; i < lprefix.length; i++) {
            lprefix[i] = Math.min(lprefix[i - 1], prices[i]);
        }
        int[] rprefix = new int[n];
        rprefix[n - 1] = prices[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rprefix[i] = Math.max(rprefix[i + 1], prices[i]);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(rprefix[i] - lprefix[i], ans);
        }
        System.out.println(ans);
    }
}