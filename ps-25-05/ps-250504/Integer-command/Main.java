// https://www.codetree.ai/ko/trails/complete/curated-cards/intro-Integer-command/description

import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int tc = 0; tc < t; tc++) {
            TreeSet<Integer> set = new TreeSet<>();
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                char command = sc.next().charAt(0);
                int num = sc.nextInt();
                if (command == 'I') {
                    set.add(num);
                } else if (command == 'D') {
                    if (set.isEmpty())
                        continue;
                    if (num == -1) {
                        set.remove(set.first());
                    } else
                        set.remove(set.last());
                }
            }
            if (set.isEmpty())
                System.out.println("EMPTY");
            else
                System.out.println(set.last() + " " + set.first());
        }
    }
}