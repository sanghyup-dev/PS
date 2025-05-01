//누적 합 배열에서 범위 내 최소와 현재 값의 차가 최대 크기임!

import java.util.Scanner;

public class Main2 {
    public static final int INT_MIN = Integer.MIN_VALUE;
    public static final int MAX_N = 100000;

    public static int n;

    public static int[] a = new int[MAX_N + 1];

    // prefixSum[i] : 1번째부터 i번째까지
    // a배열 원소의 합을 저장하고 있습니다.
    public static int[] prefixSum = new int[MAX_N + 1];

    // 누적합 배열에 적절한 값을 채워줍니다.
    public static void preprocess() {
        prefixSum[1] = a[1];

        for (int i = 2; i <= n; i++)
            prefixSum[i] = prefixSum[i - 1] + a[i];
    }

    // 배열 a의 i번째 원소부터 j번째 원소까지의 합을 반환합니다.
    public static int getSum(int i, int j) {
        return prefixSum[j] - prefixSum[i] + a[i];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        for (int i = 1; i <= n; i++)
            a[i] = sc.nextInt();

        preprocess();

        // 최댓값을 구해야 하는 문제이므로
        // 초기값을 INT_MIN으로 설정합니다.
        int ans = INT_MIN;

        // 모든 연속 부분수열 쌍에 대해 그들의 합 중
        // 최댓값을 계산합니다.
        // 이를 0 <= index1 < index2 <= n 를 만족하는 두 위치
        // index1, index2를 골라 누적합의 차가 최대가 되도록 하는
        // 문제로 해결이 가능하므로,
        // index2를 먼저 고정하고 index1은 index2 앞의 원소들 중
        // 가장 작은 원소를 골라야 차이를 최대화 할 수 있으므로
        // index2가 바뀜에따라 계속 최솟값을 O(1) 시간에 갱신하면서
        // 나아갈 수 있습니다.
        int index1 = 0;
        for (int index2 = 1; index2 <= n; index2++) {
            ans = Math.max(ans, prefixSum[index2] - prefixSum[index1]);

            if (prefixSum[index1] > prefixSum[index2])
                index1 = index2;
        }

        System.out.println(ans);
    }
}
