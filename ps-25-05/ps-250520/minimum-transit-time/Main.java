// https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-minimum-transit-time/description

import java.util.Scanner;

public class Main {

    public static int n;
    public static int m;
    public static int[] arr;

    public static boolean possible(long time) {
        long cnt = 0;
        for (int i : arr) {
            cnt += time / i;
        }
        return cnt >= n;
    }

    public static long search() {
        long l = 0;
        long r = 1L << 50;
        long mn = Long.MAX_VALUE;

        while (l <= r) {
            long mid = (l + r) / 2;
            if (possible(mid)) {
                r = mid - 1;
                mn = Math.min(mn, mid);
            } else
                l = mid + 1;
        }
        return mn;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[m];
        for (int i = 0; i < m; i++)
            arr[i] = sc.nextInt();
        System.out.println(search());
    }
}