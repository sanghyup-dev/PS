// https://www.codetree.ai/ko/trails/complete/curated-cards/intro-determine-subsequence/description

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        int[] B = new int[m];
        for (int i = 0; i < m; i++) {
            B[i] = sc.nextInt();
        }

        int cur = 0;

        for (int i = 0; i < B.length; i++) {
            while (cur < n && A[cur] != B[i]) {
                cur++;
            }
            if (cur >= n) {
                System.out.println("No");
                return;
            }
            cur++;
        }
        System.out.println("Yes");

    }
}