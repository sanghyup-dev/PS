// https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-k-distinct-characters/description

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int k = sc.nextInt();

        int mx = 0;
        int r = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        map.put(s.charAt(0), 1);

        for (int l = 0; l < s.length(); l++) {
            while (r + 1 < s.length() && map.size() <= k) {
                if (map.size() == k && !map.containsKey(s.charAt(r + 1)))
                    break;
                map.put(s.charAt(r + 1), map.getOrDefault(s.charAt(r + 1), 0) + 1);
                r++;
            }
            mx = Math.max(mx, r - l + 1);
            if (map.get(s.charAt(l)) == 1)
                map.remove(s.charAt(l));
            else
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
        }
        System.out.println(mx);
    }
}