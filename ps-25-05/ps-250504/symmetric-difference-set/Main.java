// https://www.codetree.ai/ko/trails/complete/curated-cards/test-symmetric-difference-set/description

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Set<Integer> a = new HashSet<>();
        Set<Integer> b = new HashSet<>();
        for (int i = 0; i < n; i++) {
            a.add(sc.nextInt());
        }
        for (int i = 0; i < m; i++) {
            b.add(sc.nextInt());
        }
        Set<Integer> c = new HashSet<>();
        c.addAll(a);
        c.retainAll(b);
        System.out.println(a.size() - c.size() + b.size() - c.size());

    }
}