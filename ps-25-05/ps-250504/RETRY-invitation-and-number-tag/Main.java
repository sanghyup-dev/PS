// https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-invitation-and-number-tag/description
// 모든 그룹 내 사람 수의 총합이 주어짐. 조건을 잘 보고 시간 복잡도 판단하기!

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int g = sc.nextInt();

        List<Set<Integer>> groups = new ArrayList<>();
        List<List<Integer>> peopleToGroup = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            peopleToGroup.add(new ArrayList<>());
        }
        for (int i = 0; i < g; i++) {
            groups.add(new HashSet<Integer>());
            int groupSize = sc.nextInt();
            for (int j = 0; j < groupSize; j++) {
                int person = sc.nextInt() - 1;
                groups.get(i).add(person);
                peopleToGroup.get(person).add(i);
            }
        }

        Queue<Integer> q = new ArrayDeque<>();

        Set<Integer> ans = new HashSet<>();
        q.add(0);
        ans.add(0);

        while (!q.isEmpty()) {
            int p = q.poll();
            for (int group : peopleToGroup.get(p)) { // should we change peopletogroup to queue?
                groups.get(group).remove(p);
                if (groups.get(group).size() == 1) {
                    int nxt = (groups.get(group).iterator().next());
                    if (!ans.contains(nxt)) {
                        ans.add(nxt);
                        q.add(nxt);
                    }
                }
            }
        }
        System.out.println(ans.size());
    }
}