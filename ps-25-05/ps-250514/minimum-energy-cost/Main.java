// https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-minimum-energy-cost/description

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dist = new int[n - 1];
        for (int i = 0; i < n - 1; i++)
            dist[i] = sc.nextInt();
        int[] smallest = new int[n + 1];
        smallest[0] = sc.nextInt();
        for (int i = 1; i < n - 1; i++) {
            smallest[i] = Math.min(smallest[i - 1], sc.nextInt());
        }
        sc.nextInt();

        long ans = 0;
        for (int i = 0; i < n - 1; i++) {
            ans += (long) dist[i] * smallest[i];
        }
        System.out.println(ans);
    }
}