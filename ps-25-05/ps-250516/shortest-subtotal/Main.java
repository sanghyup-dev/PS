// https://www.codetree.ai/ko/trails/complete/curated-cards/intro-shortest-subtotal/description

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }
        int cur = 1;
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <= n; i++) {
            while (sum < s) {
                if (cur > n)
                    break;
                sum += arr[cur];
                cur++;
            }
            if (cur > n)
                break;
            ans = Math.min(ans, cur - i);

            sum -= arr[i];
        }
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }
}