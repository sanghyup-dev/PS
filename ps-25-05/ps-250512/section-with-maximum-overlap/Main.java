// https://www.codetree.ai/ko/trails/complete/curated-cards/intro-section-with-maximum-overlap/description

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        List<Integer> ends = new ArrayList<>();
        HashSet<Integer> add = new HashSet<>();

        for (int i = 0; i < N; i++) {
            int x1 = sc.nextInt();
            int x2 = sc.nextInt();
            ends.add(x1);
            ends.add(x2);
            add.add(x1);
        }

        ends.sort(null);

        int mx = 0;
        int cnt = 0;
        for (int i : ends) {
            if (add.contains(i)) {
                cnt++;
                mx = Math.max(mx, cnt);
            } else
                cnt--;

        }
        System.out.println(mx);
    }
}