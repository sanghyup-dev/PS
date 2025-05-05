// https://www.codetree.ai/ko/trails/complete/curated-cards/test-small-but-big-number/description

import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            set.add(sc.nextInt());
        }
        for (int i = 0; i < m; i++) {
            Integer num = set.floor(sc.nextInt());
            if (num == null) {
                System.out.println(-1);
                continue;
            }
            System.out.println(num);
            set.remove(num);
        }

    }
}