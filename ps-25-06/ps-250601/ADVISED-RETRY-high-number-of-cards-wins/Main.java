// https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-a-high-number-of-cards-wins/submissions?page=1&page_size=20

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        boolean[] used = new boolean[2 * N + 1];
        int[] b = new int[N];
        for (int i = 0; i < N; i++) {
            b[i] = sc.nextInt();
            used[b[i]] = true;
        }

        TreeSet<Integer> aSet = new TreeSet<>();
        for (int i = 1; i <= 2 * N; i++) {
            if (!used[i])
                aSet.add(i);
        }

        int score = 0;
        for (int i = 0; i < N; i++) {
            Integer win = aSet.higher(b[i]); // B보다 큰 A의 카드 중 최소
            if (win != null) {
                score++;
                aSet.remove(win);
            } else {
                aSet.pollFirst(); // 가장 작은 카드 버리기
            }
        }

        System.out.println(score);
    }
}
