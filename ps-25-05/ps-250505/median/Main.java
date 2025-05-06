// https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-median/description
// 항상 기본적으로 오름차순. poll-> 가장 작은 값

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int m = sc.nextInt();
            int mid = sc.nextInt();
            System.out.print(mid + " ");
            Queue<Integer> smaller = new PriorityQueue<>(Collections.reverseOrder());
            Queue<Integer> larger = new PriorityQueue<>();

            for (int i = 0; i < m / 2; i++) {
                for (int j = 0; j < 2; j++) {
                    int num = sc.nextInt();
                    if (num < mid)
                        smaller.add(num);
                    else
                        larger.add(num);
                }
                if (smaller.size() > larger.size()) {
                    larger.add(mid);
                    mid = smaller.poll();
                }
                if (larger.size() > smaller.size()) {
                    smaller.add(mid);
                    mid = larger.poll();
                }
                System.out.print(mid + " ");
            }
            System.out.println();
        }
    }
}