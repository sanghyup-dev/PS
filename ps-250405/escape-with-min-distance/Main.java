//https://www.codetree.ai/ko/trails/complete/curated-cards/intro-escape-with-min-distance/description
// 거리를 잴때 처음과 끝을 포함하느냐 아니냐 꼭 확인 필요
// grid, visited, step 합칠때 각각의 값 완벽히 계산 안돼면 그냥 따로 하는게 좋다.

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
    }

    public static int m;
    public static int n;
    public static int[][] grid;
    public static int[] dx = { 1, 0, -1, 0 };
    public static int[] dy = { 0, 1, 0, -1 };

    public static Queue<Pair> q = new ArrayDeque<>();

    public static int possible = -1;

    public static void BFS() {
        while (!q.isEmpty() && possible == -1) {
            Pair cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int x = cur.x + dx[i];
                int y = cur.y + dy[i];

                if (x < 0 || x >= n || y < 0 || y >= m || grid[x][y] != 1) {
                    continue;
                }
                if (x == n - 1 && y == m - 1) {
                    possible = grid[cur.x][cur.y] + 1;
                    break;
                }
                grid[x][y] = grid[cur.x][cur.y] + 1;
                q.add(new Pair(x, y));
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        grid[0][0] = 0;
        q.add(new Pair(0, 0));
        BFS();
        System.out.println(possible);
    }
}