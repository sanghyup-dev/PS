// https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-strange-bomb/description

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

        HashMap<Integer, Integer> inRange = new HashMap<>();
        for (int i = 1; i <= Math.min(n - 1, k); i++) {
            inRange.put(arr[i], inRange.getOrDefault(arr[i], 0) + 1);
        }

        int mx = -1;

        for (int i = 0; i < n - 1; i++) {
            if (inRange.containsKey(arr[i]))
                mx = Math.max(mx, arr[i]);
            if (inRange.get(arr[i + 1]) == 1)
                inRange.remove(arr[i + 1]);
            else
                inRange.put(arr[i + 1], inRange.get(arr[i + 1]) - 1);
            if (i + k + 1 < n) {
                inRange.put(arr[i + 1 + k], inRange.getOrDefault(arr[i + 1 + k], 0) + 1);
            }
        }
        System.out.println(mx);
    }
}