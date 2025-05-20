// https://www.codetree.ai/ko/trails/complete/curated-cards/intro-find-number-fast/description

import java.util.Scanner;

public class Main {
    public static int[] arr;
    public static int n;

    public static int binarySearch(int val) {

        int l = 0;
        int r = n - 1;
        int mid = (l + r) / 2;

        while (l <= r) {
            if (val == arr[mid])
                return mid;
            else if (val < arr[mid])
                r = mid - 1;
            else
                l = mid + 1;
            mid = (l + r) / 2;
        }
        return -2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();

        arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            System.out.println(binarySearch(x) + 1);
        }
    }
}