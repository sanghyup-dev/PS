// https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-line-segments-that-do-not-overlap/description

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static class Pair {
        int s;
        int e;

        Pair(int x, int y) {
            s = x;
            e = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            pairs.add(new Pair(sc.nextInt(), sc.nextInt()));
        }

        Collections.sort(pairs, (x, y) -> (x.s - y.s));

        int[] L = new int[n];
        L[0] = pairs.get(0).e;
        for (int i = 1; i < n; i++) {
            L[i] = Math.max(L[i - 1], pairs.get(i).e);
        }
        int[] R = new int[n];
        R[n - 1] = pairs.get(n - 1).e;
        for (int i = n - 2; i >= 0; i--) {
            R[i] = Math.min(R[i + 1], pairs.get(i).e);
        }

        int ans = 0;
        for (int i = 0; i < R.length; i++) {
            boolean cross = false;
            if (i != 0) {
                if (pairs.get(i).e < L[i])
                    cross = true;
            }
            if (i != n - 1) {
                if (pairs.get(i).e > R[i])
                    cross = true;
            }
            if (!cross)
                ans++;
        }
        System.out.println(ans);
    }
}