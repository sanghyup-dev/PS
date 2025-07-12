// https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-m2-pairs-of-natural-numbers/description

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Map<Integer, Integer> nums = new HashMap<>();
        List<Integer> set = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            set.add(y);
            nums.put(y, nums.getOrDefault(y, 0) + x);
        }
        Collections.sort(set);

        int l = 0;
        int r = set.size() - 1;
        int mx = 0;

        while (l < r) {
            int lNum = set.get(l);
            int rNum = set.get(r);
            int lcnt = nums.get(lNum);
            int rcnt = nums.get(rNum);
            mx = Math.max(mx, lNum + rNum);
            if (lcnt < rcnt) {
                l++;
                nums.put(rNum, rcnt - lcnt);
            } else if (lcnt == rcnt) {
                l++;
                r--;
            } else {
                r--;
                nums.put(lNum, lcnt - rcnt);
            }
        }
        if (l == r && nums.get(set.get(l)) > 0) {
            mx = Math.max(mx, set.get(l) + set.get(r));
        }
        System.out.println(mx);
    }
}