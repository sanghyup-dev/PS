// https://www.codetree.ai/ko/trails/complete/curated-cards/intro-sum-of-n-natural-numbers/description

import java.util.Scanner;

public class Main {
    public static long search(long val) {
        long l = 0, r = 1L << 32, min = 0;

        while (l <= r) {
            long mid = (l + r) / 2;

            if (((mid * (mid + 1)) / 2) <= val) {
                l = mid + 1;
                min = Math.max(min, mid);
            } else
                r = mid - 1;
        }
        return min;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long s = sc.nextLong();
        System.out.println(search(s));
    }
}