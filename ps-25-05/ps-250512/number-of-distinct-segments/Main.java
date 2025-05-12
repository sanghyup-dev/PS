// https://www.codetree.ai/ko/trails/complete/curated-cards/intro-number-of-distinct-segments/description

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<Integer> l = new ArrayList<>();
        HashSet<Integer> add = new HashSet<>();

        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();

            l.add(s);
            l.add(e);
            add.add(s);
        }

        Collections.sort(l);

        int cnt = 0;
        int inZone = 0;

        for (int i : l) {
            if (add.contains(i)) {
                if (inZone == 0)
                    cnt++;
                inZone++;
            } else
                inZone--;
        }
        System.out.println(cnt);
    }
}