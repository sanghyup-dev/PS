// https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-drop-the-bomb/description

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static int n;
    public static int k;
    public static int[] pos;

    public static boolean possible(int r) {
        int len = r * 2;
        int cur = -3 - (len);
        int cnt = 0;

        for (int x : pos) {
            if (x <= cur + len)
                continue;
            else {
                cnt++;
                cur = x;
            }
        }
        return cnt <= k;
    }

    public static int pSearch() {
        int l = 0;
        int r = (int) 1e9 + 1;
        int mn = Integer.MAX_VALUE;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (possible(mid)) {
                r = mid - 1;
                mn = mid;
            } else {
                l = mid + 1;
            }
        }
        return mn;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        pos = new int[n];
        for (int i = 0; i < n; i++) {
            pos[i] = sc.nextInt();
        }
        Arrays.sort(pos);
        System.out.println(pSearch());
    }
}