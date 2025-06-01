// https://www.codetree.ai/ko/trails/complete/curated-cards/intro-merge-numbers/description
// 허프만 코드(Huffman Code)

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.add(sc.nextInt());
        }
        int ans = 0;

        while (pq.size() > 1) {
            int sum = pq.poll();
            sum += pq.poll();
            ans += sum;
            pq.add(sum);
        }
        System.out.println(ans);
    }
}