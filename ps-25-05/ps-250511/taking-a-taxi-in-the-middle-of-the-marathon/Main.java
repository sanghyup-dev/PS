// https://www.codetree.ai/ko/trails/complete/curated-cards/intro-taking-a-taxi-in-the-middle-of-the-marathon/description

import java.util.Scanner;

public class Main {

    public static int distance(int x1, int x2, int y1, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }
        int[] L = new int[n];
        int[] R = new int[n];

        for (int i = 1; i < n; i++) {
            L[i] = L[i - 1] + distance(x[i], x[i - 1], y[i], y[i - 1]);
        }
        for (int i = n - 2; i >= 0; i--) {
            R[i] = R[i + 1] + distance(x[i], x[i + 1], y[i], y[i + 1]);
        }
        int minDist = Integer.MAX_VALUE;
        for (int i = 1; i < n - 1; i++) {
            int dist = L[i - 1] + R[i + 1] + distance(x[i - 1], x[i + 1], y[i - 1], y[i + 1]);
            minDist = Math.min(minDist, dist);
        }
        System.out.println(minDist);
    }
}