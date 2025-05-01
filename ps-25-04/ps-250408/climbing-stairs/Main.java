//https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-climbing-stairs/description
//풀기 전 의문: 이 문제와 BFS의 차이는 뭐지? BFS로 풀수 없나? 뭐 가능이야하지.. 근데 시간이 지수적으로 급증함
//(a+b)modc=((amodc)+(bmodc))modc 와 (a⋅b)modc=((amodc)⋅(bmodc))modc 는 모두 성립한다

import java.util.Scanner;

public class Main {

    public static int n;
    public static int[] memo = new int[1010];

    public static int step(int n) {
        if (memo[n] != -1) {
            return memo[n];
        }
        if (n == 1) {
            return 0;
        }
        if (n == 2 || n == 3) {
            return 1;
        }
        return memo[n] = (step(n - 2) + step(n - 3)) % 10007;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i = 0; i < 1010; i++) {
            memo[i] = -1;
        }

        System.out.println(step(n));
    }
}