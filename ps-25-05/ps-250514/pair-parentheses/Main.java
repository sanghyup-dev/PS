// https://www.codetree.ai/ko/trails/complete/curated-cards/intro-pair-parentheses/description

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String A = sc.next();

        long ans = 0;
        int cnt = 0;

        for (int i = 1; i < A.length(); i++) {
            if (A.charAt(i) == '(' && A.charAt(i - 1) == '(')
                cnt++;
            if (A.charAt(i) == ')' && A.charAt(i - 1) == ')') {
                ans += cnt;
            }
        }
        System.out.println(ans);

    }
}