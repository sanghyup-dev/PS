//https://www.codetree.ai/ko/trails/complete/curated-cards/intro-most-frequent-data/description

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int mx = 0;
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String s = sc.next();
            map.put(s, map.getOrDefault(s, 0) + 1);
            mx = Math.max(mx, map.get(s));
        }
        System.out.println(mx);
    }
}