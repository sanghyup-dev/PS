//https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-rectangle-fill/description

import java.util.Scanner;

public class Main {

    public static int n;

    public static int[] memo = new int[10000];

    public static int fill(int n) {
        if (memo[n] != -1) {
            return memo[n];
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return memo[n] = (fill(n - 1) + fill(n - 2)) % 10007;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i < memo.length; i++) {
            memo[i] = -1;
        }
        System.out.println(fill(n));
    }
}