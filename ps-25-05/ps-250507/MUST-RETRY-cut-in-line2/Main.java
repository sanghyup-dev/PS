// https://www.codetree.ai/ko/trails/complete/curated-cards/test-cut-in-line2/description
// head tail을 쓸때 detach 방향도 중요함 앞에서 뒤에걸 땔때 head 날라갈 수 있음.(앞이 head고 뒤에가 없는 경우)
// 실패한 코드임... 다시 채우셈 attach와 detach만으로 모든걸 해결하려는 시도 실패! head때문인듯..

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static class Node {
        String name;
        Node prv, nxt;

        Node(String name) {
            this.name = name;
            prv = nxt = null;
        }
    }

    public static void attach(Node a, Node b) {
        if (a == null || b == null)
            return;
        if (heads.contains(b)) {
            heads.remove(b);
            if (a != null) {
                heads.add(a);
            }
        }
        if (a != null)
            a.nxt = b;
        if (b != null)
            b.prv = a;
    }

    public static void attachGroup(Node a, Node b, Node c) {
        if (a == null || b == null || c == null)
            return;
        if (heads.contains(c)) {
            heads.remove(c);
            heads.add(a);
        }
        b.nxt = c;
        c.prv = b;
    }

    private static void detach(Node a) {
        if (a == null)
            return;
        if (heads.contains(a)) {
            heads.remove(a);
            if (a.nxt != null)
                heads.add(a.nxt);
        }
        if (a.nxt != null)
            a.nxt.prv = null;
        a.nxt = null;
    }

    public static void detachGroup(Node a, Node b) {
        if (a == null || b == null)
            return;
        if (heads.contains(a)) {
            heads.remove(a);
            if (b.nxt != null) {
                heads.add(b.nxt);
            }
        }
        if (b.nxt != null) {
            b.nxt.prv = null;
        }
        b.nxt = null;
    }

    public static void detachBack(Node a) {
        if (a != null && a.prv != null) {
            a.prv.nxt = null;
            a.prv = null;
        }
    }

    public static HashSet<Node> heads;
    public static HashMap<String, Node> map;

    public static void main(String[] args) {
        heads = new HashSet<>();
        map = new HashMap<>();

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int Q = sc.nextInt();

        for (int i = 0; i < M; i++) {
            Node prv = null;
            for (int j = 0; j < N / M; j++) {
                Node n = new Node(sc.next());
                map.put(n.name, n);
                if (j == 0)
                    heads.add(n);
                attach(prv, n);
                prv = n;
            }
        }
        for (int i = 0; i < Q; i++) {
            int cmd = sc.nextInt();
            if (cmd == 1) {
                Node a = map.get(sc.next());
                Node b = map.get(sc.next());
                detachBack(a);
                detach(a);
                attach(b.prv, a);
                attach(a, b);
            }
            if (cmd == 2) {
                Node a = map.get(sc.next());
                detachBack(a);
                detach(a);
            }
            if (cmd == 3) {
                Node a = map.get(sc.next());
                Node b = map.get(sc.next());
                Node c = map.get(sc.next());
                Node cprv = c.prv;
                Node aprv = a.prv;
                Node bnxt = b.nxt;
                detachBack(a);
                detachGroup(a, b);
                attachGroup(a, b, c);
                attach(cprv, a);
                attach(aprv, bnxt);
            }
        }
        for (Node node : heads) {
            Node cur = node;
            while (cur != null) {
                System.out.print(cur.name + " ");
                cur = cur.nxt;
            }
            System.out.println();
        }
    }
}