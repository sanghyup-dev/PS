// https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-painting-the-grid-2/description

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int[] dx = { 1, 0, -1, 0 };
    public static int[] dy = { 0, 1, 0, -1 };

    public static int[][] visited;

    public static int BFS(int x, int y, int D) {
        Queue<Point> q = new ArrayDeque<>();
        int cnt = 1;

        visited[x][y] = 1;
        q.add(new Point(x, y));

        while (!q.isEmpty()) {
            Point p = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n)
                    continue;
                if (visited[nx][ny] == 1)
                    continue;
                if (Math.abs(board[nx][ny] - board[p.x][p.y]) > D)
                    continue;
                visited[nx][ny] = 1;
                cnt++;
                q.add(new Point(nx, ny));
            }
        }
        return cnt;
    }

    public static boolean check(int D) {
        visited = new int[n][n];
        int mx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] != 1) {
                    mx = Math.max(mx, BFS(i, j, D));
                }
            }
        }
        if (mx >= threshold)
            return true;
        return false;
    }

    public static int pSearch() {
        int l = 0;
        int r = 1_000_010;
        int mn = Integer.MAX_VALUE;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (check(mid)) {
                r = mid - 1;
                mn = Math.min(mn, mid);
            } else {
                l = mid + 1;
            }
        }
        return mn;
    }

    public static int[][] board;
    public static int n;
    public static int threshold;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        board = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = sc.nextInt();

        threshold = (int) Math.round((n * n) / 2.0);
        System.out.println(pSearch());
    }
}