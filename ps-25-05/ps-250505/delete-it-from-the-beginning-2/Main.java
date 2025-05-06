// https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-delete-it-from-the-beginning-2/description

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        Queue<Integer> pq = new PriorityQueue<>();
        double mxAvg = Math.max(arr[n - 1], arr[n - 1]);
        int sum = arr[n - 1] + arr[n - 2];
        double cnt = 1;

        pq.add(arr[n - 1]);
        pq.add(arr[n - 2]);

        for (int i = n - 3; i > 0; i--) {
            sum += arr[i];
            pq.add(arr[i]);
            cnt += 1;
            mxAvg = Math.max(mxAvg, (sum - pq.peek()) / cnt);
        }
        System.out.printf("%.2f", mxAvg);
    }
}