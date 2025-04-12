// https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-number-of-unique-bst/description

import java.util.Scanner;

public class Main {

    public static int[] memo = new int[22];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        memo[0] = 1;
        memo[1] = 1;

        for (int i = 2; i < memo.length; i++) {
            memo[i] = 0;
            for (int j = 0; j < i; j++) {
                memo[i] += memo[j] * memo[i - j - 1];
            }
        }
        System.out.println(memo[n]);
    }

}
