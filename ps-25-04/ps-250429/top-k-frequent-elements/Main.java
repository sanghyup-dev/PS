// https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-top-k-frequent-elements/description
// entrysets.. static generics.. comparables.. 개념

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, Entry.<Integer, Integer>comparingByKey().reversed());
        Collections.sort(list, Entry.<Integer, Integer>comparingByValue().reversed());
        for (int i = 0; i < k; i++) {
            System.out.print(list.get(i).getKey() + " ");
        }
    }
}