// https://www.codetree.ai/ko/trails/complete/curated-cards/intro-max-of-partial-sum-2/description
// 연속 구간 최대를 구할 때 합이 0보다 작으면 새로 시작하는게 항상 이득이다.그렇지 않다면 항상 포함하는게 이득이다.

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = sc.nextInt();
        }
        int ans = Integer.MIN_VALUE;
        int sum = 0;
        for (int i : a) {
            sum += i;
            ans = Math.max(ans, sum);
            if (sum < 0)
                sum = 0;
        }
        System.out.println(ans);
    }
}