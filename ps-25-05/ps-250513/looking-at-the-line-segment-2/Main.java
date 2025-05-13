// https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-looking-at-the-line-segment-2/description

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Main {
    public static final int CEILING = 1000_000_003;

    public static class Point {
        int idx, x, y, v;

        Point(int idx, int x, int y, int v) {
            this.idx = idx;
            this.x = x;
            this.y = y;
            this.v = v;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Point> points = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            int y = sc.nextInt();
            int x1 = sc.nextInt();
            int x2 = sc.nextInt();
            points.add(new Point(i, x1, y, +1));
            points.add(new Point(i, x2, y, -1));
        }

        Collections.sort(points, (x, y) -> {
            return x.x - y.x;
        });

        Set<Integer> set = new HashSet<>();
        TreeMap<Integer, Integer> map = new TreeMap<>(); // height->idx;

        set.add(0);
        map.put(CEILING, 0);

        for (Point p : points) {
            if (p.v == 1) {
                map.put(p.y, p.idx);
                set.add(map.get(map.firstKey()));
            } else {
                map.remove(p.y);
                set.add(map.get(map.firstKey()));
            }
        }
        System.out.println(set.size() - 1);
    }
}