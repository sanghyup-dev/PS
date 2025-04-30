//https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-sum-of-three-num/description

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
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(k - arr[i])) {
                ans += map.get(k - arr[i]);
            }
            for (int j = 0; j < i; j++) {
                map.put(arr[i] + arr[j], map.getOrDefault(arr[j] + arr[i], 0) + 1);
            }
        }
        System.out.println(ans);
    }
}
