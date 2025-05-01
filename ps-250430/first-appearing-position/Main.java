// https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-first-appearing-position/description

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int i = 1; i <= n; i++) {
            int num = sc.nextInt();
            if (!map.containsKey(num)) {
                map.put(num, i);
            }
        }
        Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, Integer> e = it.next();

            System.out.println(e.getKey() + " " + e.getValue());
        }
    }
}