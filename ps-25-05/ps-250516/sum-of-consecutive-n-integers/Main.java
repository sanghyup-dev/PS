// https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-sum-of-consecutive-n-integers/description

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        long sum = arr[0];
        int cur = 0;
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            while (sum < m && cur + 1 < n) {
                sum += arr[cur + 1];
                cur++;
            }
            if (sum == m)
                cnt++;

            sum -= arr[i];
        }
        System.out.println(cnt);
    }
}