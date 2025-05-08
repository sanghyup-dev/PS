// https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-max-rect-sum-in-grid/description
// Kadane이해하기!

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        int[][] a = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                a[i][j] = Integer.parseInt(st.nextToken());
        }

        long answer = Long.MIN_VALUE;
        long[] colSum = new long[N];

        for (int top = 0; top < N; top++) {
            // colSum 초기화
            for (int c = 0; c < N; c++)
                colSum[c] = 0;

            for (int bottom = top; bottom < N; bottom++) {
                // 현재 bottom 행을 누적
                for (int c = 0; c < N; c++)
                    colSum[c] += a[bottom][c];

                // Kadane on colSum
                long bestHere = colSum[0];
                long cur = colSum[0];
                for (int c = 1; c < N; c++) {
                    cur = Math.max(colSum[c], cur + colSum[c]);
                    bestHere = Math.max(bestHere, cur);
                }
                answer = Math.max(answer, bestHere);
            }
        }
        System.out.println(answer);
    }
}
