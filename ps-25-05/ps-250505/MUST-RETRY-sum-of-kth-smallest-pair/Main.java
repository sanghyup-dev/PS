// https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-sum-of-kth-smallest-pair/description
// hashset 사용시 equals랑 hashcode override 하기
// main2 더 직관적 풀이

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static class Pair implements Comparable<Pair> {
        int first;
        int second;

        Pair(int f, int s) {
            first = f;
            second = s;
        }

        @Override
        public int compareTo(Main.Pair o) {
            return set1.get(this.first) + set2.get(this.second) - set1.get(o.first) - set2.get(o.second);
        }

        @Override
        public boolean equals(Object obj) {
            Pair that = (Pair) obj;
            if (this.first == that.first && this.second == that.second)
                return true;
            return false;
        }

        @Override
        public int hashCode() {
            return Integer.hashCode(first + second);
        }

    }

    public static List<Integer> set1 = new ArrayList<>();
    public static List<Integer> set2 = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        for (int i = 0; i < n; i++) {
            set1.add(sc.nextInt());
        }
        for (int i = 0; i < m; i++) {
            set2.add(sc.nextInt());
        }

        Collections.sort(set1);
        Collections.sort(set2);

        Set<Pair> set = new HashSet<>();
        Queue<Pair> pq = new PriorityQueue<>();

        pq.add(new Pair(0, 0));
        set.add(new Pair(0, 0));

        while (k-- > 0) {
            if (k == 0) {
                System.out.println(set1.get(pq.peek().first) + set2.get(pq.peek().second));
                return;
            }

            int f = pq.peek().first;
            int s = pq.poll().second;
            if (f + 1 < n && !set.contains(new Pair(f + 1, s))) {
                set.add(new Pair(f + 1, s));
                pq.add(new Pair(f + 1, s));
            }
            if (s + 1 < m && !set.contains(new Pair(f, s + 1))) {
                set.add(new Pair(f, s + 1));
                pq.add(new Pair(f, s + 1));
            }

        }

    }
}