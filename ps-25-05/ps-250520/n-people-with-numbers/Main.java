// https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-n-people-with-numbers/description

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static int n;
    public static int tMax;
    public static long[] d;

    public static boolean possible(long k) {
        long time = 0;
        PriorityQueue<Long> stage = new PriorityQueue<>();
        int cur = 0;
        for (int i = 0; i < Math.min(n, k); i++) {
            stage.add(d[i]);
            cur++;
        }
        while (!stage.isEmpty()) {
            time = stage.poll();
            if (cur < n) {
                stage.add(d[cur] + time);
            }
            cur++;
        }
        return time <= tMax;
    }

    public static long search() {
        long l = 1, r = 10000, mn = 10001;

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
        tMax = sc.nextInt();
        d = new long[n];
        for (int i = 0; i < n; i++) {
            d[i] = sc.nextInt();
        }
        System.out.println(search());
    }
}