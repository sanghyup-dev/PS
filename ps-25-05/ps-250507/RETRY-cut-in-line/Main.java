// https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-cut-in-line/description
// 늘 주어진 노드가 NULL일 경우 고려해야함!
// 늘 노드가 HEAD 또는 TAIL이 아닌지 고려해야함!(사용할 경우)
// 수정시 늘 모든 연결을 전부 고려해야함!(ex detach시 detach되는 노드의 연결도 없애기)

import java.util.Scanner;

public class Main {

    public static class Node {
        int idx;
        boolean isHead;
        Node prv, nxt;

        Node(int i) {
            idx = i;
            prv = nxt = null;
            isHead = false;
        }
    }

    public static void connect(Node a, Node b) {
        if (a != null)
            a.nxt = b;
        if (b != null)
            b.prv = a;
    }

    public static void conveyHead(Node a, Node b) {
        if (a != null)
            a.isHead = false;
        if (b != null)
            b.isHead = true;
        for (int i = 0; i < heads.length; i++) {
            if (heads[i] == a) {
                heads[i] = b;
            }
        }
    }

    public static Node detach(Node a) {
        if (a.isHead) {
            conveyHead(a, a.nxt);
        }
        connect(a.prv, a.nxt);
        a.nxt = a.prv = null;
        return a;
    }

    public static void attachFront(Node a, Node b) {
        if (b.isHead) {
            conveyHead(b, a);
        }
        connect(b.prv, a);
        connect(a, b);
    }

    public static void detachGroup(Node a, Node b) {
        if (a.isHead)
            conveyHead(a, b.nxt);
        connect(a.prv, b.nxt);
        a.prv = null;
        b.nxt = null;
    }

    public static void attachGroupFront(Node a, Node b, Node c) {
        if (c.isHead)
            conveyHead(c, a);
        connect(c.prv, a);
        connect(b, c);
    }

    public static Node[] people;
    public static Node[] heads;

    public static void main(String[] args) {
        people = new Node[100_004];
        heads = new Node[11];

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int Q = sc.nextInt();

        for (int i = 0; i < M; i++) {
            int size = sc.nextInt();
            Node prv = null;
            for (int j = 0; j < size; j++) {
                Node node = new Node(sc.nextInt());
                if (j == 0) {
                    heads[i] = node;
                    node.isHead = true;
                }
                people[node.idx] = node;
                connect(prv, node);
                prv = node;
            }
        }

        for (int i = 0; i < Q; i++) {
            int cmd = sc.nextInt();
            if (cmd == 1) {
                attachFront(detach(people[sc.nextInt()]), people[sc.nextInt()]);
            }
            if (cmd == 2) {
                detach(people[sc.nextInt()]);
            }
            if (cmd == 3) {
                Node a = people[sc.nextInt()];
                Node b = people[sc.nextInt()];
                Node c = people[sc.nextInt()];
                detachGroup(a, b);
                attachGroupFront(a, b, c);
            }
        }
        for (int i = 0; i < M; i++) {
            Node cur = heads[i];
            if (cur == null) {
                System.out.println(-1);
                continue;
            }
            while (cur != null) {
                System.out.print(cur.idx + " ");
                cur = cur.nxt;
            }
            System.out.println();
        }

    }
}