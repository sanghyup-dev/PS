// https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-array-extraction-2/description

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Queue<Integer> pq = new PriorityQueue<>((x, y) -> {
            if (Math.abs(x) == Math.abs(y))
                return x - y;
            return Math.abs(x) - Math.abs(y);
        });

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            if (num == 0) {
                if (pq.isEmpty())
                    System.out.println(0);
                else
                    System.out.println(pq.poll());
            } else
                pq.add(num);
        }
    }
}