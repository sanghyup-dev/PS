// https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-group-same-word/description

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static HashMap<Character, Integer> anagram(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<HashMap<Character, Integer>, Integer> map = new HashMap<>();
        int mx = 0;
        for (int i = 0; i < n; i++) {
            String word = sc.next();
            HashMap<Character, Integer> anagramWord = anagram(word);
            map.put(anagramWord, map.getOrDefault(anagramWord, 0) + 1);
            mx = Math.max(map.get(anagramWord), mx);
        }
        System.out.println(mx);
    }
}