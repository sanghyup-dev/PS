// https://www.codetree.ai/ko/trails/complete/curated-cards/intro-hashmap-basic/description

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<Integer, Integer> dict = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String command = sc.next();
            if (command.equals("add")) {
                dict.put(sc.nextInt(), sc.nextInt());
            } else if (command.equals("find")) {
                int key = sc.nextInt();
                if (dict.containsKey(key)) {
                    System.out.println(dict.get(key));
                } else {
                    System.out.println("None");
                }
            } else if (command.equals("remove")) {
                dict.remove(sc.nextInt());
            }
        }
    }
}