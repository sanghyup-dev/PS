import java.util.Scanner;

public class Main2 {
    public static final int INT_MAX = Integer.MAX_VALUE;
    public static final int MAX_N = 100000;

    // 변수 선언
    public static int n, k, b;
    public static int[] arr = new int[MAX_N + 1];
    public static int[] prefixSum = new int[MAX_N + 1];
    public static int ans = INT_MAX;

    // [s, e] 구간 내의 원소의 합을 반환합니다.
    public static int getSum(int s, int e) {
        return prefixSum[e] - prefixSum[s - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력:
        n = sc.nextInt();
        k = sc.nextInt();
        b = sc.nextInt();
        while (b-- > 0) {
            int x = sc.nextInt();
            // 해당 숫자들이 주어진 자리에
            // 숫자 1을 적어줍니다.
            arr[x] = 1;
        }

        // 누적합 배열을 만들어줍니다.
        prefixSum[0] = 0;
        for (int i = 1; i <= n; i++)
            prefixSum[i] = prefixSum[i - 1] + arr[i];

        // 모든 구간에 대해 합을 찾아
        // 그 중 최솟값을 갱신합니다.
        for (int i = 1; i <= n - k + 1; i++)
            ans = Math.min(ans, getSum(i, i + k - 1));

        System.out.print(ans);
    }
}
