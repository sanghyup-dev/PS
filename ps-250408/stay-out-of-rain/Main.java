//https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-stay-out-of-rain/description
//발상의 전환필요. 다시 풀어볼 것.

//사람이 아닌 쉘터를 시작점으로 BFS 돌리기

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
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
    public static int h;
    public static int m;
    public static int[][] a;

    public static List<Pair> humans = new ArrayList<>();
    public static int[][] result;

    public static void BFS(int sx, int sy) {
        Queue<Pair> q = new ArrayDeque<>();
        int[][] steps = new int[n][n];
        q.add(new Pair(sx, sy));
        steps[sx][sy] = 1;
        while (!q.isEmpty() && result[sx][sy] == 0) {
            int cx = q.peek().x;
            int cy = q.poll().y;

            for (int i = 0; i < 4; i++) {
                int x = cx + dx[i];
                int y = cy + dy[i];

                if (x < 0 || y < 0 || x >= n || y >= n || steps[x][y] != 0 || a[x][y] == 1) {
                    continue;
                }
                if (a[x][y] == 3) {
                    result[sx][sy] = steps[cx][cy] + 1;
                    break;
                }
                steps[x][y] = steps[cx][cy] + 1;
                q.add(new Pair(x, y));
            }
        }
        result[sx][sy]--;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        h = sc.nextInt();
        m = sc.nextInt();
        a = new int[n][n];
        result = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
                if (a[i][j] == 2) {
                    humans.add(new Pair(i, j));
                }
            }
        }

        for (int i = 0; i < humans.size(); i++) {
            BFS(humans.get(i).x, humans.get(i).y);
        }

        for (int[] ints : result) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }

    }
}