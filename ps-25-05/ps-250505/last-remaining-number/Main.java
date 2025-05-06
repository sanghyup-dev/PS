// https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-last-remaining-number/description

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            pq.add(sc.nextInt());
        }

        while (pq.size() >= 2) {
            int first = pq.poll();
            int second = pq.poll();

            int res = Math.abs(first - second);

            if (res != 0) {
                pq.add(res);
            }
        }

        if (pq.isEmpty())
            System.out.println(-1);
        else
            System.out.println(pq.poll());
    }
}