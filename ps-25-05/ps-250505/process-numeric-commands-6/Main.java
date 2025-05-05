// https://www.codetree.ai/ko/trails/complete/curated-cards/intro-process-numeric-commands-6/description

import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

import javax.swing.Popup;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            String cmd = sc.next();
            if (cmd.equals("push"))
                q.offer(sc.nextInt());
            else if (cmd.equals("pop"))
                System.out.println(q.poll());
            else if (cmd.equals("size"))
                System.out.println(q.size());
            else if (cmd.equals("empty"))
                System.out.println(q.isEmpty() ? 1 : 0);
            else if (cmd.equals("top"))
                System.out.println(q.peek());
        }

    }
}