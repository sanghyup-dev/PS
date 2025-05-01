// https://www.codetree.ai/ko/trails/complete/curated-cards/intro-treemap-basic/description
//제발 자바잖아!!!! equals!!! wrapper라구!

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Map.Entry;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String command = sc.next();
            if (command.equals("add")) {
                int k = sc.nextInt();
                int v = sc.nextInt();
                map.put(k, v);
            } else if (command.equals("find")) {
                int k = sc.nextInt();
                if (map.containsKey(k)) {
                    System.out.println(map.get(k));
                } else {
                    System.out.println("None");
                }
            } else if (command.equals("remove")) {
                int k = sc.nextInt();
                map.remove(k);
            } else if (command.equals("print_list")) {
                if (map.isEmpty()) {
                    System.out.println("None");
                    continue;
                }
                Iterator<Entry<Integer, Integer>> it = map.entrySet().iterator();
                while (it.hasNext()) {
                    Entry<Integer, Integer> e = it.next();
                    System.out.print(e.getValue() + " ");
                }
                System.out.println();
            } else {
                System.out.println("WHAAATTTT?");
            }
        }
    }
}