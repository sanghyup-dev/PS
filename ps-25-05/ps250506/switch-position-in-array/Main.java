// https://www.codetree.ai/ko/trails/complete/curated-cards/intro-switch-position-in-array/description

import java.util.Scanner;

public class Main {
    public static class Node {
        int idx;
        Node prv, nxt;

        Node(int idx) {
            this.idx = idx;
            prv = nxt = null;
        }
    }

    public static void connect(Node a, Node b) {
        if (a != null)
            a.nxt = b;
        if (b != null)
            b.prv = a;
    }

    public static void swapRange(Node s1, Node e1, Node s2, Node e2) {
        Node tmp = s1.prv;
        connect(s2.prv, s1);
        connect(tmp, s2);
        tmp = e1.nxt;
        connect(e1, e2.nxt);
        connect(e2, tmp);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Node[] map = new Node[n + 1];
        for (int i = 1; i <= n; i++) {
            map[i] = new Node(i);
            connect(map[i - 1], map[i]);
        }

        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            swapRange(map[sc.nextInt()], map[sc.nextInt()], map[sc.nextInt()], map[sc.nextInt()]);
        }
        Node cur = map[1];
        while (cur.prv != null) {
            cur = cur.prv;
        }
        while (cur != null) {
            System.out.print(cur.idx + " ");
            cur = cur.nxt;
        }

    }
}