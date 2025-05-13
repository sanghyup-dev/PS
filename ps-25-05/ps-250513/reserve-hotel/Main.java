// https://www.codetree.ai/ko/trails/complete/curated-cards/test-reserve-hotel/description

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static class Check implements Comparable<Check> {
        int idx;
        int x;
        int v;

        Check(int idx, int x, int v) {
            this.idx = idx;
            this.x = x;
            this.v = v;
        }

        @Override
        public int compareTo(Main.Check o) {
            if (this.x == o.x) {
                if (this.v == o.v)
                    return this.idx - o.idx;
                return o.v - this.v;
            }
            return this.x - o.x;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Check> checks = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();

            checks.add(new Check(i, s, 1));
            checks.add(new Check(i, e, -1));
        }

        Collections.sort(checks);

        int layers = 0;
        int mxLayers = 0;

        for (Check c : checks) {
            layers += c.v;
            mxLayers = Math.max(mxLayers, layers);
        }
        System.out.println(mxLayers);
    }
}