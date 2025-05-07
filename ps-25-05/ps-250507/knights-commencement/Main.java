// https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-knights-commencement/description

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static class Node {
        int idx;
        Node prv, nxt;

        Node(int i) {
            idx = i;
            prv = nxt = null;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (this.nxt != null)
                sb.append(this.nxt.idx).append(" ");
            if (this.prv != null)
                sb.append(this.prv.idx);
            return sb.toString();
        }
    }

    public static void connect(Node a, Node b) {
        if (a != null)
            a.nxt = b;
        if (b != null)
            b.prv = a;
    }

    public static void pop(Node node) {
        System.out.println(node);
        connect(node.prv, node.nxt);
        node.prv = node.nxt = null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        HashMap<Integer, Node> map = new HashMap<>();

        Node prv = null;
        Node start = null;

        for (int i = 1; i <= n; i++) {
            int input = sc.nextInt();
            map.put(input, new Node(input));
            connect(prv, map.get(input));

            prv = map.get(input);
            if (i == 1)
                start = prv;
            if (i == n)
                connect(map.get(input), start);
        }

        for (int i = 0; i < m; i++) {
            pop(map.get(sc.nextInt()));
        }
    }
}