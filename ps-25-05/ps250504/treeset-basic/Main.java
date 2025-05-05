// https://www.codetree.ai/ko/trails/complete/curated-cards/intro-treeset-basic/description

import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        TreeSet<Integer> set = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            String cmd = sc.next();
            if (cmd.equals("add"))
                set.add(sc.nextInt());
            else if (cmd.equals("remove"))
                set.remove(sc.nextInt());
            else if (cmd.equals("find"))
                System.out.println(set.contains(sc.nextInt()) ? "true" : "false");
            else if (cmd.equals("lower_bound")) {
                Integer cel = set.ceiling(sc.nextInt());
                if (cel == null)
                    System.out.println("None");
                else
                    System.out.println(cel);
            } else if (cmd.equals("upper_bound")) {
                Integer cel = set.higher(sc.nextInt());
                if (cel == null)
                    System.out.println("None");
                else
                    System.out.println(cel);
            } else if (cmd.equals("largest")) {
                if (!set.isEmpty())
                    System.out.println(set.last());
                else
                    System.out.println("None");
            } else if (cmd.equals("smallest")) {
                if (!set.isEmpty())
                    System.out.println(set.first());
                else
                    System.out.println("None");
            }
        }
    }
}