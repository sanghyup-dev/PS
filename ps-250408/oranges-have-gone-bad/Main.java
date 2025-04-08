//https://www.codetree.ai/ko/trails/complete/curated-cards/test-oranges-have-gone-bad/description

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

    public static int[] dx = { 1, 0, -1, 0 };
    public static int[] dy = { 0, 1, 0, -1 };

    public static int n;
    public static int k;

    public static int[][] grid;
    public static Queue<Pair> q = new ArrayDeque<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int n = sc.nextInt();
                if (n == 2) {
                    grid[i][j] = 0;
                    q.add(new Pair(i, j));
                } else if (n == 1) {
                    grid[i][j] = -2;
                } else {
                    grid[i][j] = -1;
                }
            }
        }

        while (!q.isEmpty()) {
            int cx = q.peek().x;
            int cy = q.poll().y;

            for (int i = 0; i < 4; i++) {
                int x = cx + dx[i];
                int y = cy + dy[i];

                if (x < 0 || y < 0 || x >= n || y >= n || grid[x][y] != -2) {
                    continue;
                }

                grid[x][y] = grid[cx][cy] + 1;
                q.add(new Pair(x, y));
            }
        }

        for (int[] ints : grid) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}