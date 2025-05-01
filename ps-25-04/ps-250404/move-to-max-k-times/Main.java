//https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-move-to-max-k-times/description

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static class Pair {

        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        Pair copy() {
            return new Pair(x, y);
        }
    }

    public static int n;
    public static int k;
    public static int[][] grid;
    public static int[][] visited = new int[101][101];
    public static int[] dx = { 1, 0, -1, 0 };
    public static int[] dy = { 0, 1, 0, -1 };
    public static Queue<Pair> q = new ArrayDeque<>();

    public static int mxVal;
    public static Pair nxtCur;
    public static Pair startCur;

    public static void BFS() { // does not care about mxVal init value
        while (!q.isEmpty()) {
            Pair cur = q.poll();
            int cx = cur.x;
            int cy = cur.y;
            for (int i = 0; i < 4; i++) {
                int x = cx + dx[i];
                int y = cy + dy[i];
                if (x < 0 || x >= n || y < 0 || y >= n || grid[x][y] >= grid[startCur.x][startCur.y]
                        || visited[x][y] == 1) {
                    continue;
                }
                if (grid[x][y] > mxVal) {
                    mxVal = grid[x][y];
                    nxtCur.x = x;
                    nxtCur.y = y;
                }
                if (grid[x][y] == mxVal) {
                    if (x < nxtCur.x || (x == nxtCur.x && y < nxtCur.y)) {
                        nxtCur.x = x;
                        nxtCur.y = y;
                    }
                }
                visited[x][y] = 1;
                q.add(new Pair(x, y));
            }
        }
    }

    public static void move() {
        q.add(startCur);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = 0;
            }
        }
        mxVal = 0;
        BFS();
        startCur = nxtCur.copy();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        startCur = new Pair(sc.nextInt() - 1, sc.nextInt() - 1);
        nxtCur = startCur.copy();
        for (int i = 0; i < k; i++) {
            move();
        }
        System.out.println((startCur.x + 1) + " " + (startCur.y + 1));
    }
}