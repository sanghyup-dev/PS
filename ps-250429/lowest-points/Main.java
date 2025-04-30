// https://www.codetree.ai/ko/trails/complete/curated-cards/test-lowest-points/description
// 자료형의 범위 꼭 확인하기! overflow, underflow!

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<Long, Long> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            long x = sc.nextInt();
            long y = sc.nextInt();
            map.put(x, Math.min(map.getOrDefault(x, Long.MAX_VALUE), y));
        }
        long sum = 0;
        for (long i : map.values()) {
            sum += i;
        }
        System.out.println(sum);
    }
}