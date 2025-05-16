// https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-sum-of-two-integers-2/description

import java.util.Arrays;
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

        Arrays.sort(arr);

        int cur = n - 1;
        int cnt = 0;
        for (int i = 0; i < cur; i++) {
            while (cur > i + 1 && arr[cur] + arr[i] > k) {
                cur--;
            }
            if (cur <= i)
                break;
            if (arr[cur] + arr[i] <= k)
                cnt += cur - i;
        }
        System.out.println(cnt);
    }
}