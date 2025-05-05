// https://www.codetree.ai/ko/trails/complete/curated-cards/intro-nearest-number/description
// 초기값을 먼저 처리하는 거 위험할 수 있음.. 이 문제의 경우 sout를 까먹을 수 있음
// main2가 더 좋아 보임.

import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static int diff(Integer a, Integer b) {
        if (a == null || b == null)
            return Integer.MAX_VALUE;
        return Math.abs(a - b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        TreeSet<Integer> set = new TreeSet<>();

        set.add(0);
        int first = sc.nextInt();
        set.add(first);
        int MinDis = Math.abs(first);
        System.out.println(MinDis);

        for (int i = 1; i < n; i++) {
            int p = sc.nextInt();
            set.add(p);
            Integer rDist = set.higher(p);
            Integer lDist = set.lower(p);
            MinDis = Math.min(MinDis, diff(p, rDist));
            MinDis = Math.min(MinDis, diff(p, lDist));
            System.out.println(MinDis);
        }
    }
}