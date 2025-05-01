//https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-knight-movements/description

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

    public static int n;
    public static int r1;
    public static int c1;
    public static int r2;
    public static int c2;
    public static int[] dx = { 2, 2, 1, 1, -1, -1, -2, -2 };
    public static int[] dy = { 1, -1, -2, 2, -2, 2, 1, -1 };

    public static void BFS() {
        Queue<Pair> q = new ArrayDeque<>();
        int[][] visited = new int[n][n];
        visited[r1][c1] = 1;
        q.add(new Pair(r1, c1));

        while (!q.isEmpty()) {
            if (visited[r2][c2] != 0) {
                break;
            }
            int cx = q.peek().x;
            int cy = q.poll().y;

            for (int i = 0; i < dx.length; i++) {
                int x = cx + dx[i];
                int y = cy + dy[i];

                if (x < 0 || y < 0 || x >= n || y >= n || visited[x][y] != 0) {
                    continue;
                }
                visited[x][y] = visited[cx][cy] + 1;
                q.add(new Pair(x, y));
            }
        }

        System.out.println(visited[r2][c2] - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        r1 = sc.nextInt() - 1;
        c1 = sc.nextInt() - 1;
        r2 = sc.nextInt() - 1;
        c2 = sc.nextInt() - 1;
        BFS();
    }
}