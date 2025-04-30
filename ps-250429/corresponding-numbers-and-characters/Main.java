//https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-corresponding-numbers-and-characters/description
// just use Integer.parseInt(String s); 직접 stoi 만들 필요 없음

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static int stoi(String s) {
        int i = 0;
        for (int j = 0; j < s.length(); j++) {
            i += (s.charAt(s.length() - 1 - j) - '0') * (Math.pow(10, j));
        }
        return i;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        HashMap<String, Integer> map = new HashMap<>();
        String[] words = new String[n + 1];
        for (int i = 1; i <= n; i++) {
            words[i] = sc.next();
            map.put(words[i], i);
        }
        for (int i = 0; i < m; i++) {
            String s = sc.next();
            if (map.containsKey(s)) {
                System.out.println(map.get(s));
            } else {
                System.out.println(words[Integer.parseInt(s)]);
            }

        }
    }
}