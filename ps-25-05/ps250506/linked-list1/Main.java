// https://www.codetree.ai/ko/trails/complete/curated-cards/intro-linked-list1/description

import java.util.Scanner;

public class Main {
    public static class Node {
        String data;
        Node prv, nxt;

        Node(String data) {
            this.data = data;
            prv = nxt = null;
        }

        @Override
        public String toString() {
            return ((this.prv != null ? this.prv.data : "(Null)") + " " + this.data + " "
                    + (this.nxt != null ? this.nxt.data : "(Null)"));
        }
    }

    public static void addback(Node cur, Node node) {
        node.prv = cur;
        node.nxt = cur.nxt;
        if (node.nxt != null) {
            node.nxt.prv = node;
        }
        cur.nxt = node;
    }

    public static void addfront(Node cur, Node node) {
        node.prv = cur.prv;
        node.nxt = cur;

        if (node.prv != null) {
            node.prv.nxt = node;
        }
        cur.prv = node;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node cur = new Node(sc.next());
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int cmd = sc.nextInt();

            if (cmd == 1) {
                addfront(cur, new Node(sc.next()));
            }
            if (cmd == 2) {
                addback(cur, new Node(sc.next()));
            }
            if (cmd == 3) {
                if (cur.prv != null)
                    cur = cur.prv;
            }
            if (cmd == 4) {
                if (cur.nxt != null)
                    cur = cur.nxt;
            }
            System.out.println(cur);
        }

    }
}