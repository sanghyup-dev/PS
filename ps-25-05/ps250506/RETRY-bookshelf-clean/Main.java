
// https://www.codetree.ai/ko/trails/complete/curated-cards/intro-bookshelf-clean/description
// 다시 짜고 리팩토링까지 해보기
import java.util.Scanner;

public class Main {

    private static class Node {
        int idx;
        Node prv, nxt;

        Node(int idx) {
            this.idx = idx;
        }
    }

    private static class LinkedList {
        Node head, tail;
        int size;
    }

    /* 기본 삽입 */
    private static void addBack(LinkedList dst, Node n) {
        n.nxt = null;
        if (dst.tail == null) { // 비어 있던 리스트
            dst.head = dst.tail = n;
            n.prv = null;
        } else {
            n.prv = dst.tail;
            dst.tail.nxt = n;
            dst.tail = n;
        }
        dst.size++;
    }

    private static void addFront(LinkedList dst, Node n) {
        n.prv = null;
        if (dst.head == null) { // 비어 있던 리스트
            dst.head = dst.tail = n;
            n.nxt = null;
        } else {
            n.nxt = dst.head;
            dst.head.prv = n;
            dst.head = n;
        }
        dst.size++;
    }

    /* 1번 연산: 맨 앞 → 다른/같은 리스트 맨 뒤 */
    private static void frontToBack(LinkedList from, LinkedList to) {
        if (from.head == null)
            return; // 비어 있으면 무시
        Node n = from.head;
        from.head = n.nxt;
        if (from.head == null)
            from.tail = null;
        else
            from.head.prv = null;
        from.size--;

        addBack(to, n); // 같은 리스트라도 정상 회전
    }

    /* 2번 연산: 맨 뒤 → 다른/같은 리스트 맨 앞 */
    private static void backToFront(LinkedList from, LinkedList to) {
        if (from.tail == null)
            return;
        Node n = from.tail;
        from.tail = n.prv;
        if (from.tail == null)
            from.head = null;
        else
            from.tail.nxt = null;
        from.size--;

        addFront(to, n); // 같은 리스트라도 정상 역회전
    }

    /* 3번 연산: 전체 → 다른 리스트 앞 */
    private static void addAllFront(LinkedList src, LinkedList dst) {
        if (src.head == null || src == dst)
            return;

        if (dst.head != null) {
            src.tail.nxt = dst.head;
            dst.head.prv = src.tail;
        } else {
            dst.tail = src.tail;
        }
        dst.head = src.head;
        dst.size += src.size;

        src.head = src.tail = null;
        src.size = 0;
    }

    /* 4번 연산: 전체 → 다른 리스트 뒤 */
    private static void addAllBack(LinkedList src, LinkedList dst) {
        if (src.head == null || src == dst)
            return;

        if (dst.tail != null) {
            dst.tail.nxt = src.head;
            src.head.prv = dst.tail;
        } else {
            dst.head = src.head;
        }
        dst.tail = src.tail;
        dst.size += src.size;

        src.head = src.tail = null;
        src.size = 0;
    }

    /* -------- main -------- */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 책 수
        int k = sc.nextInt(); // 책꽂이 수
        int q = sc.nextInt(); // 연산 수 (문제 설명이 두 줄로 나뉘어도 nextInt라 상관없음)

        LinkedList[] shelf = new LinkedList[k];
        for (int i = 0; i < k; i++)
            shelf[i] = new LinkedList();

        /* 처음엔 1번 책꽂이에 1..N 책 모두 */
        for (int i = 0; i < n; i++)
            addBack(shelf[0], new Node(i));

        /* Q 개 명령 수행 */
        for (int t = 0; t < q; t++) {
            int cmd = sc.nextInt();
            int i = sc.nextInt() - 1;
            int j = sc.nextInt() - 1;

            switch (cmd) {
                case 1:
                    frontToBack(shelf[i], shelf[j]);
                    break;
                case 2:
                    backToFront(shelf[i], shelf[j]);
                    break;
                case 3:
                    addAllFront(shelf[i], shelf[j]);
                    break;
                case 4:
                    addAllBack(shelf[i], shelf[j]);
                    break;
            }
        }

        /* 결과 출력 */
        StringBuilder out = new StringBuilder();
        for (int s = 0; s < k; s++) {
            LinkedList L = shelf[s];
            out.append(L.size);
            Node cur = L.head;
            while (cur != null) {
                out.append(' ').append(cur.idx + 1);
                cur = cur.nxt;
            }
            out.append('\n');
        }
        System.out.print(out.toString());
    }
}
