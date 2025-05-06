// https://www.codetree.ai/ko/trails/complete/curated-cards/test-top-3-smallest-number/description

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();
        Queue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (long i = 0; i < Math.min(2, n); i++) {
            System.out.println(-1);
            pq.add((long) sc.nextInt());
        }
        if (n >= 3) {
            pq.add((long) sc.nextInt());
            long ans = 1;
            for (long mins : pq) {
                ans *= mins;
            }
            System.out.println(ans);
        }

        for (long i = 3; i < n; i++) {
            long challenge = sc.nextInt();
            if (pq.peek() > challenge) {
                pq.poll();
                pq.add(challenge);
            }
            long ans = 1;
            for (long mins : pq) {
                ans *= mins;
            }
            System.out.println(ans);
        }

    }
}