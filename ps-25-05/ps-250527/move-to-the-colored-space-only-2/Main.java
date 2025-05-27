// https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-move-to-the-colored-space-only-2/description

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

    public static int m;
    public static int n;
    public static int[][] board;
    public static int[][] colored;
    public static int colorN;
    public static Point start = null;

    public static int BFS(int D) {
        Queue<Point> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[m][n];
        int cnt = 1;
        visited[start.x][start.y] = true;
        q.add(start);

        while (!q.isEmpty()) {
            Point p = q.poll();
            for (int i = 0; i < 4; i++) {
                int x = p.x + dx[i];
                int y = p.y + dy[i];

                if (x < 0 || y < 0 || x >= m || y >= n)
                    continue;
                if (visited[x][y])
                    continue;
                if (Math.abs(board[x][y] - board[p.x][p.y]) > D)
                    continue;
                visited[x][y] = true;
                if (colored[x][y] == 1) {
                    cnt++;
                }
                q.add(new Point(x, y));
            }
        }
        return cnt;
    }

    public static int pSearch() {
        int l = 0;
        int r = (int) 1e9 + 1;
        int mn = r + 1;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (BFS(mid) == colorN) {
                r = mid - 1;
                mn = mid;
            } else {
                l = mid + 1;
            }
        }
        return mn;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        board = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = sc.nextInt();
        colored = new int[m][n];
        colorN = 0;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                colored[i][j] = sc.nextInt();
                if (colored[i][j] == 1) {
                    colorN++;
                    if (start == null) {
                        start = new Point(i, j);
                    }
                }
            }
        System.out.println(pSearch());
    }
}