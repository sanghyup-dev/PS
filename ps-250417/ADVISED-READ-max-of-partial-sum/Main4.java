// Divide & Conquer
// N개의 원소에 대한 최대 연속 부분합은 크기가 반인 동일한 문제를 2번 푼 다음 O(N)에 가운데 원소들을 지나는 최대 연속 부분합을
// 구하여 그 중 최댓값을 구하는 방식으로 계산이 가능합니다. 따라서 크기가 N일 때 시간복잡도를 T(N)이라 했을 때 T(N) = 2 *
// T(N/2) + O(N) 식을 만족하게 되므로, Master theorem에 의해 이 문제의 총 시간복잡도는 O(NlgN)이 됩니다.

import java.util.Scanner;

public class Main4 {
    public static final int INT_MIN = Integer.MIN_VALUE;
    public static final int MAX_N = 100000;

    public static int n;

    public static int[] a = new int[MAX_N + 1];

    // [startIdx, endIdx] 구간 내에서의
    // 최대 연속 부분합을 계산하여 반환합니다.
    public static int findMax(int startIdx, int endIdx) {
        // 원소가 하나일 때에는 그 원소를 고르는 것 만이
        // 연속 부분 수열을 만들 수 있는 방법이므로
        // 해당 원소값을 반환합니다.
        if (startIdx == endIdx)
            return a[startIdx];

        // 최댓값을 구해야 하는 문제이므로
        // 초기값을 INT_MIN으로 설정합니다.
        int maxSum = INT_MIN;

        // 가운데를 기준으로 divide & conquer를 진행합니다.
        int mid = (startIdx + endIdx) / 2;

        // Case 1 :
        // [startIdx, mid] 사이에서 가능한 최대 연속 부분 합을 계산합니다.
        maxSum = Math.max(maxSum, findMax(startIdx, mid));

        // Case 2 :
        // [mid + 1, endIdx] 사이에서 가능한 최대 연속 부분 합을 계산합니다.
        maxSum = Math.max(maxSum, findMax(mid + 1, endIdx));

        // Case 3 :
        // mid, mid + 1번째 원소를 모두 연속 부분 수열에 포함시키는 경우입니다.
        // 이 경우의 최대 연속 부분 합은
        // mid원소를 끝으로 하는 최대 연속 부분 수열과
        // mid + 1번째 원소를 시작으로 하는 최대 연속 부분 수열을 합한 경우입니다.

        int leftMaxSum = INT_MIN;
        for (int i = mid, sum = 0; i >= startIdx; i--) {
            sum += a[i];
            leftMaxSum = Math.max(leftMaxSum, sum);
        }

        int rightMaxSum = INT_MIN;
        for (int i = mid + 1, sum = 0; i <= endIdx; i++) {
            sum += a[i];
            rightMaxSum = Math.max(rightMaxSum, sum);
        }

        maxSum = Math.max(maxSum, leftMaxSum + rightMaxSum);

        // 3가지 경우 중 최대를 반환합니다.
        return maxSum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        for (int i = 1; i <= n; i++)
            a[i] = sc.nextInt();

        System.out.println(findMax(1, n));
    }
}
