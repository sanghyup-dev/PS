//https://www.codetree.ai/ko/trails/complete/curated-cards/intro-number-frequency/description

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int i = 0; i < m; i++) {

            System.out.print(map.getOrDefault(sc.nextInt(), 0) + " ");
        }
    }
}
