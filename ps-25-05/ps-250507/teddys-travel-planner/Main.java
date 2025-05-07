// https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-teddys-travel-planner/description
// circular doubly linked list에서 굳이 singleton의 prv,nxt null로 만들지 말기. 그냥 스스로 가리키게 하면 됨 LIKE MAIN2

import java.util.Scanner;

public class Main {

    public static class Node {
        String cityName;
        Node prv, nxt;

        Node(String n) {
            cityName = n;
            prv = nxt = null;
        }

        @Override
        public String toString() {
            // collects prv and nxt cityname if exists and returns
            if (prv == nxt)
                return "-1";
            StringBuilder sb = new StringBuilder();
            if (prv != null)
                sb.append(prv.cityName).append(" ");
            if (nxt != null)
                sb.append(nxt.cityName);
            return sb.toString();
        }
    }

    public static void connect(Node a, Node b) {
        if (a != null)
            a.nxt = b;
        if (b != null)
            b.prv = a;
    }

    public static Node pin = null;

    public static void mvPinRight() {
        if (pin.nxt != null) {
            pin = pin.nxt;
        }
    }

    public static void mvPinLeft() {
        if (pin.prv != null) {
            pin = pin.prv;
        }
    }

    public static void rmNxt() {
        if (pin.nxt != null) {
            if (pin.nxt.nxt != pin) {
                Node node = pin.nxt.nxt;
                pin.nxt.nxt = pin.nxt.prv = null;
                connect(pin, node);
            } else {
                pin.nxt.nxt = pin.nxt.prv = null;
                pin.nxt = pin.prv = null;
            }
        }
    }

    public static void addNxt(Node node) {
        if (pin.nxt != null)
            connect(node, pin.nxt);
        else
            connect(node, pin);
        connect(pin, node);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int q = sc.nextInt();
        Node cur = null;

        for (int i = 0; i < n; i++) {
            Node node = new Node(sc.next());
            if (i != 0)
                connect(cur, node);
            else
                pin = node;
            cur = node;
        }
        connect(cur, pin);

        for (int i = 0; i < q; i++) {
            int cmd = sc.nextInt();

            switch (cmd) {
                case 1:
                    mvPinRight();
                    break;
                case 2:
                    mvPinLeft();
                    break;
                case 3:
                    rmNxt();
                    break;
                case 4:
                    addNxt(new Node(sc.next()));
                    break;
                default:
                    break;
            }
            System.out.println(pin);
        }

    }
}