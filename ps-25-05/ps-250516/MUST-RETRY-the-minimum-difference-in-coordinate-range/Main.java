// https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-the-minimum-difference-in-coordinate-range/description

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

    private static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        Point[] pts = new Point[N];
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            pts[i] = new Point(x, y);
        }

        // 1) x-좌표 기준 정렬
        Arrays.sort(pts, Comparator.comparingInt(p -> p.x));

        // 2) 투 포인터 + TreeMap 윈도우
        TreeMap<Integer, Integer> yFreq = new TreeMap<>();
        int ans = Integer.MAX_VALUE;
        int L = 0;

        for (int R = 0; R < N; ++R) {
            // 오른쪽 포인터 확장: y 삽입
            yFreq.merge(pts[R].y, 1, Integer::sum);

            // 조건(최대−최소 ≥ D)을 만족하는 동안 왼쪽 축소
            while (!yFreq.isEmpty() &&
                    yFreq.lastKey() - yFreq.firstKey() >= D) {

                ans = Math.min(ans, pts[R].x - pts[L].x);

                // 왼쪽 점 제거
                int y = pts[L].y;
                int cnt = yFreq.get(y) - 1;
                if (cnt == 0)
                    yFreq.remove(y);
                else
                    yFreq.put(y, cnt);

                ++L;
            }
        }

        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }
}
