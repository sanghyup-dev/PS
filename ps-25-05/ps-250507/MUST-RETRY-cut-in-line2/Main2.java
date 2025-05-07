//gpt 코드

import java.io.*;
import java.util.*;

/**
 * 새치기 2 (M ≤ 10, N ≤ 1e5, Q ≤ 1e4)
 *
 * 각 줄을 sentinel(더미) 노드로 시작하는 양방향 연결‑리스트로 관리한다.
 * sentinel.name == null (실제 사람 아님)
 *
 * - detach(node) : 노드 한 개 제거
 * - detachSegment(a, b) : [a … b] 구간 제거
 * - insertBefore(t, s, e) : [s … e] 또는 단일 s 를 노드 t 앞에 삽입
 *
 * 줄 머리가 바뀌는 두 경우만 sentinel.next 를 수정하면
 * head 배열이나 lineId 없이도 O(1) 에 관리된다.
 */
public class Main2 {

    // -------- 노드 정의 --------
    private static class Node {
        String name; // sentinel 은 null
        Node prev, next;

        Node(String name) {
            this.name = name;
        }
    }

    // -------- 전역 --------
    private static Node[] sentinel; // 줄마다 하나씩
    private static Map<String, Node> nodeOf; // 이름 → 노드

    // ---------------- 기본 조작 ----------------
    /** 단일 노드를 줄에서 제거한다. */
    private static void detach(Node x) {
        Node p = x.prev, n = x.next;
        p.next = n;
        if (n != null)
            n.prev = p;
        // x 는 고아(node.prev, node.next 유지 안 해도 무방)
    }

    /** [a … b] 구간을 줄에서 제거하고 (prevSeg, nextSeg) 반환 */
    private static Node[] detachSegment(Node a, Node b) {
        Node p = a.prev, n = b.next;
        p.next = n;
        if (n != null)
            n.prev = p;
        return new Node[] { p, n }; // 구간 앞/뒤 노드
    }

    /** 구간 [s … e] 를 target t *앞* 에 삽입한다. (단, s==e 가능) */
    private static void insertBefore(Node t, Node s, Node e) {
        Node p = t.prev;
        p.next = s;
        s.prev = p;
        e.next = t;
        t.prev = e;
    }

    // ---------------- 명령 처리 ----------------
    /** 명령 1: a 가 b 앞에 끼어든다. */
    private static void cutIn(String A, String B) {
        Node a = nodeOf.get(A);
        Node b = nodeOf.get(B);
        if (a == b)
            return;

        // 1) a 떼어내기
        detach(a);

        // 2) b 앞에 삽입
        insertBefore(b, a, a);
    }

    /** 명령 2: a 가 줄에서 떠난다. */
    private static void leave(String A) {
        Node a = nodeOf.get(A);
        detach(a);
    }

    /** 명령 3: [a … b] 블록을 c 앞에 삽입 */
    private static void groupCutIn(String A, String B, String C) {
        Node a = nodeOf.get(A);
        Node b = nodeOf.get(B);
        Node c = nodeOf.get(C);

        if (a == c)
            return; // c 가 구간 첫 노드라면 변화 없음

        // 1) [a … b] 떼어내기
        detachSegment(a, b);

        // 2) c 앞에 삽입
        insertBefore(c, a, b);
    }

    // ---------------- 출력 ----------------
    private static void printLines(int M, StringBuilder sb) {
        for (int i = 0; i < M; i++) {
            Node cur = sentinel[i].next;
            if (cur == null) {
                sb.append("-1\n");
                continue;
            }
            while (cur != null) {
                sb.append(cur.name).append(' ');
                cur = cur.next;
            }
            sb.setLength(sb.length() - 1); // 마지막 공백 제거
            sb.append('\n');
        }
    }

    // ---------------- 메인 ----------------
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        int N = fs.nextInt();
        int M = fs.nextInt();
        int Q = fs.nextInt();

        sentinel = new Node[M];
        for (int i = 0; i < M; i++)
            sentinel[i] = new Node(null);

        nodeOf = new HashMap<>(N * 2);

        int perLine = N / M; // 항상 나누어떨어짐
        for (int line = 0; line < M; line++) {
            Node prev = sentinel[line];
            for (int j = 0; j < perLine; j++) {
                Node cur = new Node(fs.next());
                nodeOf.put(cur.name, cur);
                prev.next = cur;
                cur.prev = prev;
                prev = cur;
            }
        }

        for (int i = 0; i < Q; i++) {
            int cmd = fs.nextInt();
            if (cmd == 1) {
                cutIn(fs.next(), fs.next());
            } else if (cmd == 2) {
                leave(fs.next());
            } else { // cmd == 3
                groupCutIn(fs.next(), fs.next(), fs.next());
            }
        }

        StringBuilder out = new StringBuilder();
        printLines(M, out);
        System.out.print(out);
    }

    // ---------------- 빠른 입력 ----------------
    private static class FastScanner {
        private final byte[] buffer = new byte[1 << 16];
        private int bId, size;
        private final InputStream in;

        FastScanner(InputStream in) {
            this.in = in;
        }

        private int readByte() throws IOException {
            if (bId == size) {
                size = in.read(buffer);
                bId = 0;
                if (size == -1)
                    return -1;
            }
            return buffer[bId++];
        }

        String next() throws IOException {
            StringBuilder sb = new StringBuilder();
            int c;
            while ((c = readByte()) <= ' ')
                if (c == -1)
                    return null;
            do {
                sb.append((char) c);
            } while ((c = readByte()) > ' ');
            return sb.toString();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}
