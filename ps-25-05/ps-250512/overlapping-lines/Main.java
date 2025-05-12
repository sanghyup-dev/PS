// https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-overlapping-lines/description

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int cur = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            int dis = sc.nextInt();
            int dir = sc.next().charAt(0);

            if (dir == 'R') {
                map.put(cur, map.getOrDefault(cur, 0) + 1);
                set.add(cur);
                cur += dis;
                map.put(cur, map.getOrDefault(cur, 0) - 1);
                set.add(cur);
            } else {
                map.put(cur, map.getOrDefault(cur, 0) - 1);
                set.add(cur);
                cur -= dis;
                map.put(cur, map.getOrDefault(cur, 0) + 1);
                set.add(cur);
            }
        }
        List<Integer> s = new ArrayList<>(set);
        Collections.sort(s);

        int ans = 0;
        int cnt = 0;
        int start = 0;
        for (int i : s) {
            if (cnt < k) {
                cnt += map.get(i);
                if (cnt >= k)
                    start = i;
            } else {
                cnt += map.get(i);
                if (cnt < k)
                    ans += i - start;
            }
        }
        System.out.println(ans);
    }
}