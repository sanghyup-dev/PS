// https://www.codetree.ai/ko/trails/complete/curated-cards/intro-distributing-integers/description

import java.util.Scanner;

public class Main {

    public static int n;
    public static int m;
    public static int[] arr;
    public static int maxVal = 0;

    public static boolean possible(int val) {
        int cnt = 0;

        for (int i : arr) {
            cnt += i / val;
        }
        return cnt >= m;
    }

    public static int search() {
        int l = 1, r = maxVal, mx = 0;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (possible(mid)) {
                l = mid + 1;
                mx = Math.max(mx, mid);
            } else
                r = mid - 1;
        }
        return mx;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            maxVal = Math.max(maxVal, arr[i]);
        }
        System.out.println(search());
    }
}