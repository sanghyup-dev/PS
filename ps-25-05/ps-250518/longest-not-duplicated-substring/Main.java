// https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-longest-not-duplicated-substring/description

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        Set<Character> set = new HashSet<>();
        set.add(s.charAt(0));

        int r = 0;

        int mx = 0;
        for (int l = 0; l < s.length(); l++) {

            while (r + 1 < s.length() && !set.contains(s.charAt(r + 1))) {
                set.add(s.charAt(r + 1));
                r++;
            }
            mx = Math.max(mx, set.size());
            set.remove(s.charAt(l));
        }
        System.out.println(mx);
    }
}