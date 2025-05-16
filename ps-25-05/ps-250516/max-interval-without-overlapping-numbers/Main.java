// https://www.codetree.ai/ko/trails/complete/curated-cards/intro-max-interval-without-overlapping-numbers/description

import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int cur = 0;

        HashSet<Integer> set = new HashSet<>();

        int ans = 0;
        set.add(arr[0]);

        for (int i = 0; i < n; i++) {
            while (cur + 1 < n && !set.contains(arr[cur + 1])) {
                set.add(arr[cur + 1]);
                cur++;
            }

            ans = Math.max(ans, cur - i + 1);
            set.remove(arr[i]);
        }
        System.out.println(ans);
    }
}