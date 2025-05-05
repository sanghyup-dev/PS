// https://www.codetree.ai/ko/trails/complete/curated-cards/intro-min-integer-output/description

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            if (num == 0) {
                if (pq.isEmpty())
                    System.out.println(0);
                else
                    System.out.println(pq.poll());
            } else {
                pq.add(num);
            }
        }
    }
}