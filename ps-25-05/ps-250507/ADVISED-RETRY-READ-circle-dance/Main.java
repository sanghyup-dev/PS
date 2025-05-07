// https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-circle-dance/description
// 관련 노드 저장 -> 항상 detach먼저 -> 다음 attach 공식이 과연 성립하는가?
// 한 노드는 4개의 연결 가지고 있음. 두 노드는 2개의 연결로 연뎔됨. 하나의 연결을 이으면 기존 연결은 끊김.

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static class Node {
        int studentNo;
        Node prv, nxt;

        Node(int n) {
            studentNo = n;
            prv = nxt = null;
        }
    }

    public static void connect(Node a, Node b) {
        if (a != null)
            a.nxt = b;
        if (b != null)
            b.prv = a;
    }

    public static void detach(Node a) {
        if (a.nxt != null)
            a.nxt.prv = null;
        a.nxt = null;
    }

    public static HashMap<Integer, Node> map;

    public static void main(String[] args) {
        map = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int Q = sc.nextInt();

        for (int i = 0; i < M; i++) {
            Node prv = null;
            Node first = null;
            int n = sc.nextInt();

            for (int j = 0; j < n; j++) {
                Node node = new Node(sc.nextInt());
                if (j == 0)
                    first = node;
                map.put(node.studentNo, node);
                connect(prv, node);
                prv = node;
            }
            connect(prv, first);
        }

        for (int i = 0; i < Q; i++) {
            int cmd = sc.nextInt();
            if (cmd == 1) {
                Node a = map.get(sc.nextInt());
                Node b = map.get(sc.nextInt());

                Node aNxt = a.nxt;
                Node bPrv = b.prv;
                detach(a);
                detach(bPrv);
                connect(a, b);
                connect(bPrv, aNxt);
            }
            if (cmd == 2) {
                Node a = map.get(sc.nextInt());
                Node b = map.get(sc.nextInt());
                Node aPrv = a.prv;
                Node bPrv = b.prv;
                detach(aPrv);
                detach(bPrv);
                connect(bPrv, a);
                connect(aPrv, b);
            }
            if (cmd == 3) {
                Node a = map.get(sc.nextInt());
                Node smallestNode = a;
                Node cur = a;
                while (true) {
                    if (smallestNode.studentNo > cur.studentNo)
                        smallestNode = cur;
                    cur = cur.nxt;
                    if (cur == a)
                        break;
                }
                cur = smallestNode;
                while (true) {
                    System.out.print(cur.studentNo + " ");
                    cur = cur.prv;
                    if (cur == smallestNode)
                        break;
                }
            }
        }
    }
}