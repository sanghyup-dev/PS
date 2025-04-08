// https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-remove-k-walls/description
// 그리드 BFS의 핵심 요소: 방향dx,dy/큐/원본그리드/방문그리드/거리그리드/초기화(큐+각 그리드)/큐 빌때까지 반복/연결된 모든 노드
// 검사(그리드 벗어나기/중복/그리드 조건)/가능 노드 반영(그리드 반영+큐에 추가)
// 짧은 버젼: 큐/그리드/초기화/루프/방향/후보/조건/반영

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static class Tuple {

        int x;
        int y;
        int z = 0;

        Tuple(int x, int y) {
            this.x = x;
            this.y = y;
        }

        Tuple(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

    }

    public static int n;
    public static int k;
    public static int[][] grid;
    public static int[][][] dists;
    public static int[] dx = { 1, 0, -1, 0 };
    public static int[] dy = { 0, 1, 0, -1 };

    public static int r1;
    public static int c1;
    public static int r2;
    public static int c2;
    public static int mn = -1;

    public static void BFS() {
        Queue<Tuple> q = new ArrayDeque<>();
        dists[r1][c1][0] = 1;
        q.add(new Tuple(r1, c1));
        boolean end = false;
        while (!q.isEmpty() && !end) {
            int cx = q.peek().x;
            int cy = q.peek().y;
            int cz = q.poll().z;
            for (int i = 0; i < 4; i++) {
                int x = cx + dx[i];
                int y = cy + dy[i];
                int z = cz;
                if (x < 0 || y < 0 || x >= n || y >= n) {
                    continue;
                }
                if (grid[x][y] == 1) {
                    z++;
                }
                if (z > k) {
                    continue;
                }
                if (dists[x][y][z] != 0) {
                    continue;
                }
                dists[x][y][z] = dists[cx][cy][cz] + 1;
                if (x == r2 && y == c2) {
                    mn = dists[x][y][z] - 1;
                    end = true;
                    break;
                }
                q.add(new Tuple(x, y, z));
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        grid = new int[n][n];
        dists = new int[n][n][k + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        r1 = sc.nextInt() - 1;
        c1 = sc.nextInt() - 1;
        r2 = sc.nextInt() - 1;
        c2 = sc.nextInt() - 1;

        BFS();
        System.out.println(mn);
    }
}