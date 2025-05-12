// https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-section-with-maximum-overlap-2/description

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Integer> l = new ArrayList<>();
        Set<Integer> h = new HashSet<>();

        for (int i = 0; i < n; i++) {
            int x1 = sc.nextInt();
            int x2 = sc.nextInt();
            l.add(x1);
            l.add(x2);
            h.add(x1);
        }

        Collections.sort(l);
        int mx = 0;
        int cnt = 0;
        for (Integer integer : l) {
            if (h.contains(integer)) {
                cnt++;
                mx = Math.max(mx, cnt);
            } else
                cnt--;
        }
        System.out.println(mx);
    }
}