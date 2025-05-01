// https://www.codetree.ai/ko/trails/complete/curated-cards/intro-hashset-basic/description

import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String command = sc.next();
            int x = sc.nextInt();
            if (command.equals("find")) {
                if (set.contains(x)) {
                    System.out.println(true);
                } else
                    System.out.println("false");
            } else if (command.equals("add")) {
                set.add(x);
            } else if (command.equals("remove")) {
                set.remove(x);
            }
        }
    }
}