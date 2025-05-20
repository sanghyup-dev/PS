// https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-determine-possibility-of-subsequence/description

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] A = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            A[i] = Long.parseLong(st.nextToken());

        long[] B = new long[M + 2]; // 1-based, sentinel 양끝
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= M; i++)
            B[i] = Long.parseLong(st.nextToken());

        int[] prefix = new int[M + 1]; // prefix[0] = -1
        Arrays.fill(prefix, Integer.MAX_VALUE);
        prefix[0] = -1;

        int pA = 0;
        for (int i = 1; i <= M && pA < N; i++) {
            while (pA < N && A[pA] != B[i])
                pA++;
            if (pA == N)
                break; // 더는 매칭 불가
            prefix[i] = pA;
            pA++;
        }

        int[] suffix = new int[M + 2]; // suffix[M+1] = N
        Arrays.fill(suffix, -1);
        suffix[M + 1] = N;

        pA = N - 1;
        for (int i = M; i >= 1 && pA >= 0; i--) {
            while (pA >= 0 && A[pA] != B[i])
                pA--;
            if (pA < 0)
                break;
            suffix[i] = pA;
            pA--;
        }

        int ans = 0;
        for (int k = 1; k <= M; k++) {
            int left = prefix[k - 1];
            int right = suffix[k + 1];
            if (left != Integer.MAX_VALUE && right != -1 && left < right)
                ans++;
        }
        System.out.println(ans);
    }
}
