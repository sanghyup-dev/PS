// https://www.codetree.ai/ko/trails/complete/curated-cards/intro-linked-list2/description

import java.util.Scanner;

public class Main {

    public static class Node {
        int data;
        Node prv, nxt;

        Node(int d) {
            data = d;
            prv = nxt = null;
        }

        @Override
        public String toString() {
            return ((this.prv != null ? this.prv.data : 0) + " "
                    + (this.nxt != null ? this.nxt.data : 0));
        }
    }

    public static void remove(Node node) {
        if (node.prv != null) {
            node.prv.nxt = node.nxt;
        }
        if (node.nxt != null) {
            node.nxt.prv = node.prv;
        }
        node.nxt = node.prv = null;
    }

    public static void addfront(Node cur, Node node) {
        node.prv = cur.prv;
        node.nxt = cur;
        if (node.prv != null) {
            node.prv.nxt = node;
        }
        cur.prv = node;
    }

    public static void addback(Node cur, Node node) {
        node.prv = cur;
        node.nxt = cur.nxt;
        if (node.nxt != null) {
            node.nxt.prv = node;
        }
        cur.nxt = node;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Node[] map = new Node[n + 1];
        for (int i = 1; i <= n; i++) {
            map[i] = new Node(i);
        }
        int q = sc.nextInt();

        for (int i = 0; i < q; i++) {
            int cmd = sc.nextInt();

            if (cmd == 1) {
                remove(map[sc.nextInt()]);
            }
            if (cmd == 2) {
                addfront(map[sc.nextInt()], map[sc.nextInt()]);
            }
            if (cmd == 3) {
                addback(map[sc.nextInt()], map[sc.nextInt()]);
            }
            if (cmd == 4) {
                System.out.println(map[sc.nextInt()]);
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.print((map[i].nxt != null ? map[i].nxt.data : 0) + " ");
        }

    }
}