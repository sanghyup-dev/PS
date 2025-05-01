//https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-minimum-difference-on-the-integer-grid-2/description
//숫자가 작으면 약간의 Bruteforce 고려해보기
//마지막 코드 꼭 이해해보기!!(그 전에 tabulation으로 다시 풀어보기): hint: 모든 경로에서 오는 최대최소값을 전부 영리하게 저장.

//treeset 설명:
// Property      :  Behavior
// Sorted order	 :  Elements are automatically sorted
// No duplicates :	Like all sets, duplicates are ignored
// Log time ops  : 	add(), remove(), and contains() take O(log N) time
// Navigation    :	Has methods like higher(), lower(), ceiling(), floor()

//sliding window: Expand right, shrink left if invalid, update answer when valid
// int left = 0;
// for (int right = 0; right < n; right++) {
//     add(right);
//     while (!valid()) remove(left++);
//     update();
// }

// int right = start;
// for (int left = 0; left < n; left++) {
//     while (right < n && !valid(left, right)) {
//         right++;
//     }
//     if (right < n) {
//         update(right - left + 1);
//     }
// }

import java.util.*;

public class Main {

    static int n;
    static int[][] grid;
    static int[] dx = { 1, 0 };
    static int[] dy = { 0, 1 };

    // Check whether there's a path from (0, 0) to (n-1, n-1)
    // only using values in the range [low, high]
    static boolean canReach(int low, int high) {
        if (grid[0][0] < low || grid[0][0] > high)
            return false;

        boolean[][] visited = new boolean[n][n];
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] { 0, 0 });
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            if (x == n - 1 && y == n - 1)
                return true;

            for (int dir = 0; dir < 2; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n &&
                        !visited[nx][ny] &&
                        grid[nx][ny] >= low && grid[nx][ny] <= high) {
                    visited[nx][ny] = true;
                    q.add(new int[] { nx, ny });
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];

        TreeSet<Integer> valueSet = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
                valueSet.add(grid[i][j]);
            }
        }

        // Extract sorted unique values
        List<Integer> values = new ArrayList<>(valueSet);
        int minDiff = Integer.MAX_VALUE;

        int j = 0;
        for (int i = 0; i < values.size(); i++) {
            while (j < values.size() && !canReach(values.get(i), values.get(j))) {
                j++;
            }
            if (j < values.size()) {
                minDiff = Math.min(minDiff, values.get(j) - values.get(i));
            } else
                break; // optimization
        }

        System.out.println(minDiff);
    }
}

// ONLY control LowerBound use DP to get upperbound for each lowerbound
// import java.util.Scanner;

// public class Main {
// public static final int INT_MAX = Integer.MAX_VALUE;
// public static final int MAX_R = 100;
// public static final int MAX_N = 100;

// // 변수 선언
// public static int n;
// public static int[][] num = new int[MAX_N][MAX_N];
// public static int[][] dp = new int[MAX_N][MAX_N];

// public static int ans = INT_MAX;

// public static void initialize() {
// // 전부 INT_MAX로 초기화합니다.
// for(int i = 0; i < n; i++)
// for(int j = 0; j < n; j++)
// dp[i][j] = INT_MAX;

// // 시작점의 경우 dp[0][0] = num[0][0]으로 초기값을 설정해줍니다
// dp[0][0] = num[0][0];

// // 최좌측 열의 초기값을 설정해줍니다.
// for(int i = 1; i < n; i++)
// dp[i][0] = Math.max(dp[i - 1][0], num[i][0]);

// // 최상단 행의 초기값을 설정해줍니다.
// for(int j = 1; j < n; j++)
// dp[0][j] = Math.max(dp[0][j - 1], num[0][j]);
// }

// public static int solve(int lowerBound) {
// // lowerBound 미만의 값은 사용할 수 없도록
// // num값을 변경해줍니다.
// for(int i = 0; i < n; i++)
// for(int j = 0; j < n; j++)
// if(num[i][j] < lowerBound)
// num[i][j] = INT_MAX;

// // DP 초기값 설정
// initialize();

// // 탐색하는 위치의 위에 값과 좌측 값 중에 작은 값과
// // 해당 위치의 숫자 중에 최댓값을 구해줍니다.
// for(int i = 1; i < n; i++)
// for(int j = 1; j < n; j++)
// dp[i][j] = Math.max(
// Math.min(dp[i - 1][j], dp[i][j - 1]),
// num[i][j]
// );

// return dp[n - 1][n - 1];
// }

// public static void main(String[] args) {
// Scanner sc = new Scanner(System.in);
// // 입력
// n = sc.nextInt();

// for(int i = 0; i < n; i++)
// for(int j = 0; j < n; j++)
// num[i][j] = sc.nextInt();

// // 최솟값을 lowerBound라고 가정했을 때
// // lowerBound 이상의 수들만 사용하여
// // 이동한다는 조건하에서
// // 최댓값을 최소로 만드는 DP 문제를 풀어줍니다.
// for(int lowerBound = 1; lowerBound <= MAX_R; lowerBound++) {
// int upperBound = solve(lowerBound);

// // 다 진행했음에도 여전히 INT_MAX라면
// // 그러한 이동이 불가능하다는 뜻이므로
// // 패스합니다.
// if(upperBound == INT_MAX)
// continue;

// // 답을 갱신합니다.
// ans = Math.min(ans, upperBound - lowerBound);
// }

// System.out.print(ans);
// }
// }

// tabulation

// 상세설명
// // 최상단 행의 초기값을 설정해줍니다.
// for(int j = 1; j < n; j++)
// for(int k = 1; k <= MAX_R; k++)
// dp[0][j][Math.min(k, num[0][j])] = Math.min(
// dp[0][j][Math.min(k, num[0][j])],
// Math.max(dp[0][j - 1][k], num[0][j])
// );
// }

// ❗ "최솟값 k ≥ 현재값인 모든 경로에 대해,
// 최솟값은 num[i][j]로 덮어씌워지고,
// 그 결과 dp[i][j][num[i][j]]에 기록된다.
// (왜냐면 새로운 min은 num[i][j]가 되니까)

// ❗ 반대로, k < 현재값인 경로는,
// min 값이 그대로 유지되므로 dp[i][j][k] 위치에
// 새로운 max를 저장할 수 있다."

// import java.util.Scanner;

// public class Main {
// public static final int INT_MAX = Integer.MAX_VALUE;
// public static final int MAX_R = 100;
// public static final int MAX_N = 100;

// // 변수 선언
// public static int n;
// public static int[][] num = new int[MAX_N][MAX_N];
// public static int[][][] dp = new int[MAX_N][MAX_N][MAX_R + 1];

// public static int ans = INT_MAX;

// public static void initialize() {
// // 전부 INT_MAX로 초기화합니다.
// for(int i = 0; i < n; i++)
// for(int j = 0; j < n; j++)
// for(int k = 1; k <= MAX_R; k++)
// dp[i][j][k] = INT_MAX;

// // 시작점의 경우 dp[0][0][num[0][0]] = num[0][0]으로 초기값을 설정해줍니다
// dp[0][0][num[0][0]] = num[0][0];

// // 최좌측 열의 초기값을 설정해줍니다.
// for(int i = 1; i < n; i++)
// for(int k = 1; k <= MAX_R; k++)
// dp[i][0][Math.min(k, num[i][0])] = Math.min(
// dp[i][0][Math.min(k, num[i][0])],
// Math.max(dp[i - 1][0][k], num[i][0])
// );

// // 최상단 행의 초기값을 설정해줍니다.
// for(int j = 1; j < n; j++)
// for(int k = 1; k <= MAX_R; k++)
// dp[0][j][Math.min(k, num[0][j])] = Math.min(
// dp[0][j][Math.min(k, num[0][j])],
// Math.max(dp[0][j - 1][k], num[0][j])
// );
// }

// public static void solve() {
// // DP 초기값 설정
// initialize();

// // 탐색하는 위치의 위에 값과 좌측 값 중에 작은 값과
// // 해당 위치의 숫자 중에 최댓값을 구해줍니다.
// for(int i = 1; i < n; i++)
// for(int j = 1; j < n; j++)
// for(int k = 1; k <= MAX_R; k++) {
// dp[i][j][Math.min(k, num[i][j])] = Math.min(
// dp[i][j][Math.min(k, num[i][j])],
// Math.max(Math.min(dp[i - 1][j][k], dp[i][j - 1][k]), num[i][j])
// );
// }

// }

// public static void main(String[] args) {
// Scanner sc = new Scanner(System.in);
// // 입력
// n = sc.nextInt();

// for(int i = 0; i < n; i++)
// for(int j = 0; j < n; j++)
// num[i][j] = sc.nextInt();

// // DP로 문제를 해결합니다.
// solve();

// // 가능한 답 중 최적의 답을 계산합니다.
// int ans = INT_MAX;
// for(int k = 1; k <= MAX_R; k++)
// if(dp[n - 1][n - 1][k] != INT_MAX)
// ans = Math.min(ans, dp[n - 1][n - 1][k] - k);

// System.out.print(ans);
// }
// }
