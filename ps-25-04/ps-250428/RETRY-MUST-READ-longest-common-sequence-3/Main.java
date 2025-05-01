// https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-longest-common-sequence-3/description

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] A = new int[n + 2]; // 1-based; extra row/col of zeros simplifies code
        int[] B = new int[m + 2];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; ++i)
            A[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int j = 1; j <= m; ++j)
            B[j] = Integer.parseInt(st.nextToken());

        /* ---------- 1. ordinary LCS length DP ---------- */
        int[][] len = new int[n + 2][m + 2];
        for (int i = n; i >= 1; --i)
            for (int j = m; j >= 1; --j)
                len[i][j] = (A[i] == B[j])
                        ? 1 + len[i + 1][j + 1]
                        : Math.max(len[i + 1][j], len[i][j + 1]);

        /* ---------- 2. greedy reconstruction ---------- */
        StringBuilder sb = new StringBuilder();
        int i = 1, j = 1;
        while (i <= n && j <= m && len[i][j] > 0) {
            int chosenVal = 1001, chosenI = -1, chosenJ = -1;

            /* find the smallest feasible next value */
            for (int ii = i; ii <= n; ++ii) {
                for (int jj = j; jj <= m; ++jj) {
                    if (A[ii] == B[jj] && len[ii][jj] == len[i][j]) {
                        if (A[ii] < chosenVal) {
                            chosenVal = A[ii];
                            chosenI = ii;
                            chosenJ = jj;
                        }
                        break; // B has no duplicate for this value
                    }
                }
            }

            /* append and move past the chosen element */
            sb.append(chosenVal).append(' ');
            i = chosenI + 1;
            j = chosenJ + 1;
        }

        if (sb.length() != 0)
            sb.setLength(sb.length() - 1); // trim trailing space
        System.out.println(sb);
    }
}
