// https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-take-place/description

import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        TreeSet<Integer> set = new TreeSet<>();

        for (int i = 1; i <= m; i++) {
            set.add(i);
        }
        for (int i = 0; i < n; i++) {
            int req = sc.nextInt();
            Integer seat = set.floor(req);
            if (seat == null)
                break;
            set.remove(seat);
        }
        System.out.println(m - set.size());
    }
}