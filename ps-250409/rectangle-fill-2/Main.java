//https://www.codetree.ai/ko/trails/complete/curated-cards/test-rectangle-fill-2/description
//DP tip: 다음 단계에서 동등한 상황으로 볼 수 있는 이전 단계를 유추 = 1칸 전일 때 어떤 조합으로 구성되었든 다음 진행은 동일

import java.util.Scanner;

public class Main {
    public static int num;

    public static int[] memo = new int[1001];

    public static int find(int n) {
        if (memo[n] != -1) {
            return memo[n];
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 3;
        }
        return memo[n] = (find(n - 1) + find(n - 2) * 2) % 10_007;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();
        for (int i = 0; i < memo.length; i++) {
            memo[i] = -1;
        }

        System.out.println(find(num));
    }
}
