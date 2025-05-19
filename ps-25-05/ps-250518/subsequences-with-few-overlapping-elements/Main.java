// https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-subsequences-with-few-overlapping-elements/description

import java.util.HashMap;
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

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(arr[0], 1);

        int mx = 0;
        int r = 0;
        for (int l = 0; l < n; l++) {
            while (r + 1 < n && map.getOrDefault(arr[r + 1], 0) < k) {
                map.put(arr[r + 1], map.getOrDefault(arr[r + 1], 0) + 1);
                r++;
            }
            mx = Math.max(mx, r - l + 1);

            map.put(arr[l], map.getOrDefault(arr[l], 0) - 1);

        }
        System.out.println(mx);
    }
}