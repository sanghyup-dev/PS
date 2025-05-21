// https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-ascending-order-of-two-dimensional-array/description

import java.util.Scanner;

public class Main {
    public static long n;
    public static long k;

    public static long Npos(long val) {
        long cnt = 0;
        for (long i = 1; i <= Math.min(n, val); i++) {
            cnt += Math.min(n, val / i);
        }
        return cnt;
    }

    public static long search(long val) {
        long l = 1, r = Integer.MAX_VALUE;
        while (l <= r) {
            long mid = (l + r) / 2;
            long start = Npos(mid - 1) + 1;
            long end = Npos(mid);
            if (start <= val && val <= end) {
                return mid;
            } else if (val < start) {
                r = mid - 1;
            } else
                l = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextLong();
        k = sc.nextLong();
        System.out.println(search(k));
    }
}