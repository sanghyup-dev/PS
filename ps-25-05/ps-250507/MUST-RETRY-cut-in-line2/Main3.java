// 코드트리 정답

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static final int MAX_N = 100000;
    static final int MAX_M = 10;

    // 사람들을 나타내는 노드입니다.
    static class Node {
        // 사람의 번호를 나타냅니다.
        String name;
        Node prev, next;

        Node(String name) {
            this.name = name;
            this.prev = null;
            this.next = null;
        }
    }

    static Node[] nodes = new Node[MAX_N + 1];
    static Node[] head = new Node[MAX_M + 1];
    static Node[] tail = new Node[MAX_M + 1];
    static int[] lineNum = new int[MAX_N + 1];
    static HashMap<String, Integer> personId = new HashMap<>();

    // 두 사람을 연결합니다.
    static void connect(Node s, Node e) {
        if (s != null)
            s.next = e;
        if (e != null)
            e.prev = s;
    }

    // i번 사람을 집에 보냅니다.
    static void pop(Node i) {
        int l = lineNum[personId.get(i.name)];

        if (l == 0)
            return;

        if (head[l] == i)
            head[l] = head[l].next;
        if (tail[l] == i)
            tail[l] = tail[l].prev;

        if (i.prev != null)
            i.prev.next = i.next;
        if (i.next != null)
            i.next.prev = i.prev;

        lineNum[personId.get(i.name)] = 0;
        i.next = i.prev = null;
    }

    // a번 사람을 b번 사람 앞에 서게 합니다.
    static void insertFront(Node a, Node b) {
        int lineNumB = lineNum[personId.get(b.name)];
        if (head[lineNumB] == b)
            head[lineNumB] = a;
        pop(a);

        connect(b.prev, a);
        connect(a, b);

        lineNum[personId.get(a.name)] = lineNumB;
    }

    // a번 사람부터 b번 사람까지를 c번 사람 앞에 이동합니다.
    static void popRangeAndInsertPrev(Node a, Node b, Node c) {
        int lineNumA = lineNum[personId.get(a.name)];
        int lineNumC = lineNum[personId.get(c.name)];

        if (head[lineNumA] == a)
            head[lineNumA] = b.next;
        if (tail[lineNumA] == b)
            tail[lineNumA] = a.prev;

        connect(a.prev, b.next);

        if (head[lineNumC] == c) {
            connect(b, c);
            head[lineNumC] = a;
        } else {
            connect(c.prev, a);
            connect(b, c);
        }

        Node cur = a;
        while (cur != b) {
            lineNum[personId.get(cur.name)] = lineNumC;
            cur = cur.next;
        }
        lineNum[personId.get(cur.name)] = lineNumC;
    }

    // 해당 줄을 전부 출력합니다.
    static void printLine(int l) {
        Node cur = head[l];

        if (cur == null) {
            System.out.println(-1);
            return;
        }

        while (cur != null) {
            System.out.print(cur.name + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int q = sc.nextInt();

        int personNum = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 0; j < n / m; j++) {
                String t = sc.next();
                personId.put(t, personNum);
                lineNum[personNum] = i;

                if (j == 0) {
                    tail[i] = head[i] = nodes[personNum] = new Node(t);
                } else {
                    nodes[personNum] = new Node(t);
                    connect(tail[i], nodes[personNum]);
                    tail[i] = nodes[personNum];
                }

                personNum++;
            }
        }

        while (q-- > 0) {
            int option = sc.nextInt();

            if (option == 1) {
                String x = sc.next();
                String y = sc.next();
                int a = personId.get(x), b = personId.get(y);
                insertFront(nodes[a], nodes[b]);
            } else if (option == 2) {
                String x = sc.next();
                int a = personId.get(x);
                pop(nodes[a]);
            } else if (option == 3) {
                String x = sc.next();
                String y = sc.next();
                String z = sc.next();
                int a = personId.get(x), b = personId.get(y), c = personId.get(z);
                popRangeAndInsertPrev(nodes[a], nodes[b], nodes[c]);
            }
        }

        for (int i = 1; i <= m; i++)
            printLine(i);
    }
}
