// https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-waiting-for-the-bus/description

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static int n;
    public static int m;
    public static int c;
    public static int[] t;

    public static boolean possible(int time) {
        int cnt = 0;
        int cur = (int) -1e9 - 10;
        int cap = 0;

        for (int x : t) {
            if (x <= cur + time && cap < c) {
                cap++;
            } else {
                cap = 1;
                cnt++;
                cur = x;
            }
        }
        return cnt <= m;
    }

    public static int pSearch() {
        int l = 0, r = (int) 1e9 + 1, mn = r + 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (possible(mid)) {
                r = mid - 1;
                mn = mid;
            } else
                l = mid + 1;
        }
        return mn;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        c = sc.nextInt();
        t = new int[n];
        for (int i = 0; i < n; i++) {
            t[i] = sc.nextInt();
        }
        Arrays.sort(t);
        System.out.println(pSearch());

    }
}