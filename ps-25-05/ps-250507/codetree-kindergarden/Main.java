// https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-codetree-kindergarden/description

import java.util.Scanner;

public class Main {

    public static class Node {
        int studentNo;
        Node prv, nxt;

        Node(int n) {
            studentNo = n;
            prv = nxt = null;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (this.nxt == null || this.prv == null)
                return "-1";
            sb.append(this.prv.studentNo).append(" ").append(this.nxt.studentNo);
            return sb.toString();
        }
    }

    public static class LinkedList {
        Node head;
        Node tail;
        int size;

        LinkedList(Node head, Node tail, int size) {
            this.head = head;
            this.tail = tail;
            this.size = size;
        }
    }

    public static void connect(Node a, Node b) {
        if (a != null)
            a.nxt = b;
        if (b != null)
            b.prv = a;
    }

    public static int linedNo = 1;

    public static void addBack(Node node, LinkedList linkedList) {
        if (linkedList.size == 0)
            return;
        Node nxt = node.nxt;
        connect(node, linkedList.head);
        connect(linkedList.tail, nxt);
        linedNo += linkedList.size;
    }

    public static void addFront(Node node, LinkedList linkedList) {
        if (linkedList.size == 0)
            return;
        Node prv = node.prv;
        connect(linkedList.tail, node);
        connect(prv, linkedList.head);
        linedNo += linkedList.size;
    }

    public static LinkedList mklist(int size) {
        LinkedList ll = new LinkedList(null, null, size);
        Node prv = null;
        for (int i = linedNo + 1; i < linedNo + 1 + size; i++) {
            Node node = new Node(i);
            map[i] = node;
            if (i == linedNo + 1)
                ll.head = node;
            if (i == linedNo + size)
                ll.tail = node;
            connect(prv, node);
            prv = node;
        }
        return ll;
    }

    public static Node[] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        map = new Node[100_004];

        map[1] = new Node(1);

        while (q-- > 0) {
            int cmd = sc.nextInt();

            switch (cmd) {
                case 1:
                    addBack(map[sc.nextInt()], mklist(sc.nextInt()));
                    break;
                case 2:
                    addFront(map[sc.nextInt()], mklist(sc.nextInt()));
                    break;
                case 3:
                    System.out.println(map[sc.nextInt()]);
                    break;
                default:
                    break;

            }
        }

    }
}