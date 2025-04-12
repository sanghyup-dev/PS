
//https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-lis-on-the-integer-grid/description
//다시 한번 풀어보기.
//가장 작은 숫자에서 시작이라는 개념을 버려야하나봐. 그저 현재 길이는 다음 단계에 비해 어느정도인가?만 생각해보고 시작.
// 핵심: DFS가 뻗어나가는 방향과 카운팅하는 방향이 반대

// //첫 시도(시작점만 잘 선정해서 BFS): N^4가 나옴 절대 안됨
// import java.util.ArrayDeque;
// import java.util.Queue;
// import java.util.Scanner;

// public class Main {
//     public static class Pair {
//         int x;
//         int y;

//         public Pair(int x, int y) {
//             this.x = x;
//             this.y = y;
//         }
//     }

//     public static int n;
//     public static int[][] grid;
//     public static int[][] dist;
//     public static int[] dx = { 1, 0, -1, 0 };
//     public static int[] dy = { 0, 1, 0, -1 };

//     public static Queue<Pair> q = new ArrayDeque<>();

//     public static boolean canGo(int x, int y) {
//         return x >= 0 && y >= 0 && x < n && y < n;
//     }

//     public static void initBFS() {
//         for (int i = 0; i < grid.length; i++) {
//             for (int j = 0; j < grid.length; j++) {
//                 boolean start = true;
//                 for (int j2 = 0; j2 < 4; j2++) {
//                     int x = i + dx[j2];
//                     int y = j + dy[j2];
//                     if (canGo(x, y)) {
//                         if (grid[x][y] < grid[i][j]) {
//                             start = false;
//                             break;
//                         }
//                     }
//                 }
//                 if (start) {
//                     dist[i][j] = 1;
//                     q.add(new Pair(i, j));
//                 }

//             }
//         }
//     }

//     public static void BFS() {
//         initBFS();
//         while (!q.isEmpty()) {
//             int cx = q.peek().x;
//             int cy = q.poll().y;
//             for (int i = 0; i < 4; i++) {
//                 int x = cx + dx[i];
//                 int y = cy + dy[i];

//                 if (!canGo(x, y))
//                     continue;
//                 if (grid[x][y] <= grid[cx][cy])
//                     continue;
//                 if (dist[x][y] >= (dist[cx][cy] + 1))
//                     continue;

//                 dist[x][y] = dist[cx][cy] + 1;
//                 q.add(new Pair(x, y));
//             }
//         }
//     }

//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         n = sc.nextInt();
//         grid = new int[n][n];
//         dist = new int[n][n];
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < n; j++) {
//                 grid[i][j] = sc.nextInt();
//             }
//         }
//         BFS();
//         int mx = 0;
//         for (int[] is : dist) {
//             for (int i : is) {
//                 mx = Math.max(i, mx);
//             }
//         }
//         System.out.println(mx);
//     }
// }

// // 모든 숫자를 정렬 (N^2logN)
// import java.util.Scanner;
// import java.util.ArrayList;
// import java.util.Collections;

// class Cell implements Comparable<Cell> {
//     int num, x, y;

//     public Cell(int num, int x, int y) {
//         this.num = num;
//         this.x = x;
//         this.y = y;
//     }

//     @Override
//     public int compareTo(Cell c) {
//         return this.num - c.num; // num 기준으로 오름차순 정렬합니다.
//     }
// }

// public class Main {
//     public static final int DIR_NUM = 4;
//     public static final int MAX_N = 500;

//     // 변수 선언
//     public static int n;
//     public static int[][] grid = new int[MAX_N][MAX_N];
//     public static int[][] dp = new int[MAX_N][MAX_N];

//     public static ArrayList<Cell> cells = new ArrayList<>();
//     public static int ans = 0;

//     public static boolean inRange(int x, int y) {
//         return 0 <= x && x < n && 0 <= y && y < n;
//     }

//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         // 입력
//         n = sc.nextInt();

//         for (int i = 0; i < n; i++)
//             for (int j = 0; j < n; j++)
//                 grid[i][j] = sc.nextInt();

//         // 각 칸에 적혀있는 정수값 기준으로
//         // 오름차순이 되도록 칸의 위치들을 정렬합니다.
//         // 편하게 정렬하기 위해
//         // (칸에 적혀있는 값, 행 위치, 열 위치) 순으로 넣어줍니다.
//         for (int i = 0; i < n; i++)
//             for (int j = 0; j < n; j++)
//                 cells.add(new Cell(grid[i][j], i, j));

//         // 오름차순으로 정렬을 진행합니다.
//         Collections.sort(cells);

//         // 처음 DP 값들은 전부 1로 초기화해줍니다. (해당 칸에서 시작하는 경우)
//         for (int i = 0; i < n; i++)
//             for (int j = 0; j < n; j++)
//                 dp[i][j] = 1;

//         // 정수값이 작은 칸부터 순서대로 보며
//         // 4방향에 대해 dp 값을 갱신해줍니다.
//         for (int i = 0; i < cells.size(); i++) {
//             int x = cells.get(i).x;
//             int y = cells.get(i).y;
//             int[] dx = new int[] { -1, 1, 0, 0 };
//             int[] dy = new int[] { 0, 0, -1, 1 };

//             // 인접한 4개의 칸에 대해 갱신을 진행합니다.
//             for (int j = 0; j < DIR_NUM; j++) {
//                 int nx = x + dx[j], ny = y + dy[j];
//                 if (inRange(nx, ny) && grid[nx][ny] > grid[x][y])
//                     dp[nx][ny] = Math.max(dp[nx][ny], dp[x][y] + 1);
//             }
//         }

//         // 전체 수들 중 최댓값을 찾습니다.
//         for (int i = 0; i < n; i++)
//             for (int j = 0; j < n; j++)
//                 ans = Math.max(ans, dp[i][j]);

//         System.out.print(ans);
//     }
// }

// DFS+Memoization(DP) = N^2
import java.util.Scanner;

public class Main {
    public static final int DIR_NUM = 4;
    public static final int MAX_N = 500;

    // 변수 선언
    public static int n;
    public static int[][] grid = new int[MAX_N][MAX_N];
    public static int[][] dp = new int[MAX_N][MAX_N];

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }

    // (x, y)에서 출발하여 조건을 만족하며
    // 도달할 수 있는 칸의 수 중
    // 최대 칸의 수를 구합니다.
    public static int findMax(int x, int y) {
        // 이미 계산해본적이 있다면
        // 그 값을 바로 반환합니다.
        if (dp[x][y] != -1)
            return dp[x][y];

        // 기본값은 자기자신이 됩니다.
        int best = 1;

        // 정수값이 작은 칸부터 순서대로 보며
        // 4방향에 대해 최적의 칸 수를 계산합니다.
        int[] dx = new int[] { -1, 1, 0, 0 };
        int[] dy = new int[] { 0, 0, -1, 1 };

        for (int j = 0; j < DIR_NUM; j++) {
            int nx = x + dx[j], ny = y + dy[j];
            if (inRange(nx, ny) && grid[nx][ny] > grid[x][y])
                best = Math.max(best, findMax(nx, ny) + 1);
        }

        return dp[x][y] = best;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        n = sc.nextInt();

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();

        // 메모이제이션을 위해
        // 전부 초기값을 -1로 셋팅해줍니다.
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                dp[i][j] = -1;

        // 각 칸에 시작했을 떄
        // 최대로 이동할 수 있는 칸의 수 중
        // 최댓값을 갱신합니다.
        int ans = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                ans = Math.max(ans, findMax(i, j));

        System.out.print(ans);
    }
}
