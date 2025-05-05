// https://www.codetree.ai/ko/trails/complete/curated-cards/intro-keep-picking-the-big-number/description

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            q.add(sc.nextInt());
        }
        for (int i = 0; i < m; i++) {
            q.add(q.poll() - 1);
        }
        System.out.println(q.poll());

    }
}