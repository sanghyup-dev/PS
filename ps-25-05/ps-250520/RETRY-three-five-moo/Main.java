// https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-three-five-moo/description
// moo인 부분을 없애기 위해 lowerbound 필요

import java.util.Scanner;

public class Main {

    public static long findNo(long x) {
        return x - x / 3 - x / 5 + x / 15;
    }

    public static long search(long val) {
        long l = 1;
        long r = 1L << 32;
        long ans = Long.MAX_VALUE;
        while (l <= r) {
            long mid = (l + r) / 2;
            if (findNo(mid) >= val) {
                r = mid - 1;
                ans = Math.min(ans, mid);
            } else
                l = mid + 1;

        }
        return ans;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        System.out.println(search(n));
    }
}