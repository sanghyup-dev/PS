// https://www.codetree.ai/ko/trails/complete/curated-cards/intro-count-number-of-points-3/description

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int Q = sc.nextInt();

        Queue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            pq.add(sc.nextInt());
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        int id = 1;
        while (!pq.isEmpty()) {
            map.put(pq.poll(), id++);
        }

        for (int i = 0; i < Q; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            System.out.println(map.get(end) - map.get(start) + 1);

        }
    }
}