//gpt

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 두 그룹의 원소 수를 최대로 만드는 프로그램
 *
 * 조건: 같은 그룹 안 모든 숫자의 최대‒최소 차가 K 이하여야 한다.
 * 알고리즘: 정렬 + 두 번의 슬라이딩 윈도우(prefix/suffix 최대길이) → O(N log N)
 */
public class Main3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] a = new int[n];
        for (int i = 0; i < n; ++i) {
            a[i] = Integer.parseInt(br.readLine().trim());
        }

        Arrays.sort(a);

        // prefix[i] = 0..i 구간까지 가능한 최대 그룹 크기
        int[] prefix = new int[n];
        int left = 0;
        for (int right = 0; right < n; ++right) {
            while (a[right] - a[left] > k)
                ++left; // 조건 위반 시 왼쪽 이동
            int len = right - left + 1; // 현재 윈도우 길이
            prefix[right] = (right == 0) ? len
                    : Math.max(prefix[right - 1], len);
        }

        // suffix[i] = i..n-1 구간에서 가능한 최대 그룹 크기
        int[] suffix = new int[n];
        int right = n - 1;
        for (int l = n - 1; l >= 0; --l) {
            while (a[right] - a[l] > k)
                --right; // 조건 위반 시 오른쪽 이동
            int len = right - l + 1;
            suffix[l] = (l == n - 1) ? len
                    : Math.max(suffix[l + 1], len);
        }

        // 두 구간으로 나눠 최대 합 계산
        int answer = prefix[n - 1]; // 한 구간만 쓸 수도 있음
        for (int cut = 0; cut < n - 1; ++cut) {
            answer = Math.max(answer, prefix[cut] + suffix[cut + 1]);
        }

        System.out.println(answer);
    }
}
