//https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-pattern-matching/description
//다시 풀때는 DP로 풀어보기

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String p = sc.next();

        int it = p.length() - 1;
        int cur = s.length() - 1;
        while (it >= 0) {
            if (p.charAt(it) == '*') {
                it--;
                char toMatch = p.charAt(it--);
                if (cur == -1) {
                    continue;
                }
                if (toMatch == '.') {
                    toMatch = s.charAt(cur);
                }
                while (it >= 0 && p.charAt(it) == toMatch && cur >= 0 && s.charAt(cur) == toMatch) {
                    it--;
                    cur--;
                }
                while (cur >= 0 && s.charAt(cur) == toMatch)
                    cur--;
            } else {
                if (cur < 0) {
                    System.out.println("false");
                    return;
                }
                if (p.charAt(it) == '.') {
                    it--;
                    cur--;
                    continue;
                }
                if (p.charAt(it) == s.charAt(cur)) {
                    it--;
                    cur--;
                    continue;
                }
                System.out.println("false");
                return;
            }
        }
        System.out.println("true");
    }
}