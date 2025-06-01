import java.util.Scanner;
import java.util.Arrays;

public class Main2 {
    public static final int MAX_N = 100000;

    // 변수 선언
    public static int n, k, l;
    public static int[] arr = new int[MAX_N];

    // h 이상의 수를 h개 이상
    // 만들 수 있을지 판단합니다.
    public static boolean isPossible(int h) {
        // 이미 크기가 큰 h개의 수들에 대해
        // 전부 h 이상이 되기 위해
        // 새로 적혀야 하는 번호의 수를 계산합니다.
        long cnt = 0;
        for (int i = n - h; i < n; i++) {
            if (arr[i] < h)
                cnt += h - arr[i];
        }

        // 새로 적혀야 하는 번호의 수가 최대로 적을 수 있는 수인 k * l 이하이며
        // arr[n - h] + k가 h 이상이어야만 k개의 포스트잇으로 해결이 가능합니다.
        return cnt <= (long) k * l && arr[n - h] + k >= h;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력
        n = sc.nextInt();
        k = sc.nextInt();
        l = sc.nextInt();
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        // 주어진 수들을
        // 오름차순으로 정렬합니다.
        Arrays.sort(arr, 0, n);

        int left = 1; // 답이 될 수 있는 가장 작은 값을 설정합니다.
        int right = n; // 답이 될 수 있는 가장 큰 값을 설정합니다.
        int ans = 0; // 답을 저장합니다.

        while (left <= right) { // [left, right]가 유효한 구간이면 계속 수행합니다.
            int mid = (left + right) / 2; // 가운데 위치를 선택합니다.
            if (isPossible(mid)) { // 결정문제에 대한 답이 Yes라면
                left = mid + 1; // 오른쪽에 조건을 만족하는 숫자가 더 있을 가능성 때문에 left를 바꿔줍니다.
                ans = Math.max(ans, mid); // 답의 후보들 중 최댓값을 계속 갱신해줍니다.
            } else
                right = mid - 1; // 결정문제에 대한 답이 No라면 right를 바꿔줍니다.
        }

        System.out.print(ans);
    }
}
