// https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-the-number-with-the-smallest-difference/description
// 검색 지점이 굳이 실존하는 노드가 아니어도 됨.
// 이런 상황에서 TreeSet가 떠올라야함.

import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int ans = Integer.MAX_VALUE;
        TreeSet<Integer> set = new TreeSet<>();
        set.add(sc.nextInt());
        for (int i = 1; i < n; i++) {
            int p = sc.nextInt();
            set.add(p);
            Integer lval = set.floor(p - m);
            Integer rval = set.ceiling(p + m);
            if (lval != null)
                ans = Math.min(ans, p - lval);
            if (rval != null)
                ans = Math.min(ans, rval - p);
        }
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }
}