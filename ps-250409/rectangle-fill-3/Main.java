//https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-rectangle-fill-3/description
//DP 생각 순서: 시각화 -> subproblem 인식 -> Extra 확인(ex: recurring tail) -> 시작점 확인 -> tabulation or memoization

import java.util.Scanner;

public class Main {

    public static int n;

    public static long[] memo = new long[10000];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i < memo.length; i++) {
            memo[i] = -1;
        }

        memo[0] = 1;
        memo[1] = 2;
        memo[2] = 7;

        long extra = 0;

        for (int i = 3; i <= n; i++) {
            extra += memo[i - 3] % 1_000_000_007;
            memo[i] = (memo[i - 1] * 2 + memo[i - 2] * 3 + extra * 2) % 1_000_000_007;
        }
        System.out.println(memo[n]);

    }
}