// https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-note-and-sticky-note/description

import java.io.*;
import java.util.*;

public class Main {
    static int N, K, L;
    static int[] c; // 원본 카운트

    /** h-index 를 h로 만들 수 있으면 true */
    static boolean can(int h) {
        int satisfied = 0;
        List<Integer> deltaList = new ArrayList<>();

        for (int v : c) {
            if (v >= h) {
                satisfied++;
            } else {
                int delta = h - v;
                if (delta <= K)
                    deltaList.add(delta); // 고칠 수 있는 후보
            }
        }

        if (satisfied >= h)
            return true; // 이미 OK

        int needCnt = h - satisfied; // 더 필요한 권 수
        if (deltaList.size() < needCnt)
            return false; // 후보가 부족

        Collections.sort(deltaList); // 작은 delta부터

        long sum = 0;
        for (int i = 0; i < needCnt; i++) {
            sum += deltaList.get(i);
            if (sum > 1L * K * L)
                return false; // 용량 초과
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        c = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            c[i] = Integer.parseInt(st.nextToken());

        int lo = 0, hi = N, ans = 0;
        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            if (can(mid)) { // mid 가능 → 더 키워 봄
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        System.out.println(ans);
    }
}
