//https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-glacier/description

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

    public static int[] dx = { 1, 0, -1, 0 };
    public static int[] dy = { 0, 1, 0, -1 };

    public static int n;
    public static int m;
    public static int[][] grid;

    public static int prvcnt = 0;
    public static int cnt;
    public static int it;

    public static void iter() {
        it++;
        int[][] visited = new int[n][m];
        Queue<Pair> toMelt = new ArrayDeque<>();
        Queue<Pair> q = new ArrayDeque<>();
        visited[0][0] = 1;
        q.add(new Pair(0, 0));

        while (!q.isEmpty()) {
            int cx = q.peek().x;
            int cy = q.poll().y;

            for (int i = 0; i < 4; i++) {
                int x = cx + dx[i];
                int y = cy + dy[i];

                if (x < 0 || x >= n || y < 0 || y >= m || visited[x][y] == 1) {
                    continue;
                }
                visited[x][y] = 1;

                if (grid[x][y] == 1) {
                    toMelt.add(new Pair(x, y));
                } else {
                    q.add(new Pair(x, y));
                }
            }
        }

        for (Pair pair : toMelt) {
            grid[pair.x][pair.y] = 0;
            cnt--;
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
                cnt += grid[i][j];
            }
        }
        while (true) {
            prvcnt = cnt;
            iter();
            if (cnt == 0) {
                System.out.println(it + " " + prvcnt);
                break;
            }
        }
    }
}