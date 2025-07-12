// https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-the-bomb-dismantling/description

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static class Bomb {
        int score;
        int timeLimit;

        Bomb(int s, int t) {
            score = s;
            timeLimit = t;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Bomb> bombs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            bombs.add(new Bomb(sc.nextInt(), sc.nextInt()));
        }
        Collections.sort(bombs, (x, y) -> (x.timeLimit - y.timeLimit));

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (Bomb bomb : bombs) {
            if (pq.size() < bomb.timeLimit) {
                pq.add(bomb.score);
            } else {
                if (pq.peek() < bomb.score) {
                    pq.poll();
                    pq.add(bomb.score);
                }
            }
        }
        int ans = 0;
        for (Integer integer : pq) {
            ans += integer;
        }
        System.out.println(ans);
    }
}