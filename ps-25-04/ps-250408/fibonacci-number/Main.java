//https://www.codetree.ai/ko/trails/complete/curated-cards/intro-fibonacci-number/description
// 변수에 값 입력과 반환 동시에 가능: return memo[n] = fib(n - 1) + fib(n - 2); 가능!

import java.util.Scanner;

public class Main {

    public static int[] fibo = new int[46];

    public static int fibo(int n) {
        if (fibo[n] != 0) {
            return fibo[n];
        }
        if (n == 1 || n == 2) {
            fibo[n] = 1;
            return 1;
        } else {
            fibo[n] = fibo(n - 1) + fibo(n - 2);
            return fibo[n];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(fibo(n));
    }
}