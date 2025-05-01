//https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-sum-of-two-num/description

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            if (map.containsKey(k - num)) {
                ans += map.get(k - num);
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        System.out.println(ans);
    }
}