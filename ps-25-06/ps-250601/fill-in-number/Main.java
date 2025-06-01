// https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-fill-in-number/description

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n == 1 || n == 3) {
            System.out.println(-1);
            return;
        }
        int cnt = n / 5;
        n %= 5;
        if (n % 2 == 0) {
            cnt += n / 2;
        } else {
            n += 5;
            if (n % 2 == 0) {
                cnt += n / 2 - 1;
            }
        }
        System.out.println(cnt);
    }
}