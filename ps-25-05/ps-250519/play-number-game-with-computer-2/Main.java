// https://www.codetree.ai/ko/trails/complete/curated-cards/test-play-number-game-with-computer-2/description

import java.util.Scanner;

public class Main {

    public static long binarySearch(long target, long m) {
        long l = 1, r = m, cnt = 0;
        while (l <= r) {
            long mid = (l + r) / 2;
            cnt++;
            if (target == mid) {
                return cnt;
            } else if (target < mid) {
                r = mid - 1;
            } else
                l = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long m = sc.nextLong();
        long a = sc.nextLong();
        long b = sc.nextLong();

        long mn = Long.MAX_VALUE;
        long mx = Long.MIN_VALUE;
        for (long i = a; i <= b; i++) {
            long cnt = binarySearch(i, m);
            mn = Math.min(cnt, mn);
            mx = Math.max(cnt, mx);
        }
        System.out.println(mn + " " + mx);
    }
}