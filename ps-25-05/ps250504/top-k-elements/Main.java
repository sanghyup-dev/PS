// https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-top-k-elements/description

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            set.add(sc.nextInt());
        }
        Iterator<Integer> it = set.iterator();
        for (int i = 0; i < k; i++) {
            System.out.print(it.next() + " ");
        }
    }
}