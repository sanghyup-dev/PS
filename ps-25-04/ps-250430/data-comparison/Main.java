// https://www.codetree.ai/ko/trails/complete/curated-cards/intro-data-comparison/description

import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashSet<Integer> arr1 = new HashSet<>();
        for (int i = 0; i < n; i++) {
            arr1.add(sc.nextInt());
        }
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            System.out.print((arr1.contains(sc.nextInt()) ? 1 : 0) + " ");
        }
    }
}