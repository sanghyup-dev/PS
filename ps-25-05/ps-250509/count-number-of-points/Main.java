// https://www.codetree.ai/ko/trails/complete/curated-cards/test-count-number-of-points/description

import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int q = sc.nextInt();

        TreeSet<Integer> dots = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            dots.add(sc.nextInt());
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        int idx = 1;
        for (Integer i : dots) {
            map.put(i, idx++);
        }

        for (int i = 0; i < q; i++) {
            int bottom = dots.ceiling(sc.nextInt());
            int top = dots.floor(sc.nextInt());

            System.out.println(map.get(top) - map.get(bottom) + 1);
        }

    }
}