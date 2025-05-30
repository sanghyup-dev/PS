// https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-minimize-the-height-difference/description

import java.util.Scanner;

public class Main {
    public static int n;
    public static int m;
    public static int[][] board;

    public static int[] dx = { 1, 0, -1, 0 };
    public static int[] dy = { 0, 1, 0, -1 };

    public static boolean[][] visited;

    public static void dfs(int x, int y, int lBound, int hBound) {
        if (visited[n - 1][m - 1])
            return;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny])
                continue;
            if (board[nx][ny] > hBound || board[nx][ny] < lBound)
                continue;
            visited[nx][ny] = true;
            dfs(nx, ny, lBound, hBound);
        }
    }

    public static boolean isPossible(int l, int r) {
        if (board[0][0] < l || board[0][0] > r)
            return false;
        visited = new boolean[n][m];
        visited[0][0] = true;
        dfs(0, 0, l, r);
        return visited[n - 1][m - 1];

    }

    public static int pSearch(int lBound) {
        int l = lBound, r = 500, mn = 501;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (isPossible(lBound, mid)) {
                r = mid - 1;
                mn = Math.min(mn, mid);
            } else
                l = mid + 1;
        }
        return mn;
    }

    public static int findMin() {
        int ans = Integer.MAX_VALUE;
        for (int lbound = 1; lbound < 501; lbound++) {
            int hBound = pSearch(lbound);
            if (hBound != 501) {
                ans = Math.min(ans, hBound - lbound);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        board = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                board[i][j] = sc.nextInt();
        System.out.println(findMin());
    }
}