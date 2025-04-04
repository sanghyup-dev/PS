//https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-clear-stones-well/description
// 제귀가 꼭 iteration 수로 종료조건이 형성되는 것이 아니다. 대신 종료 조건이 잘 구성되어야한다.
// 이 문제의 경우 idx가 돌 개수를 초과하거나, 돌을 전부 선택하거나의 두가지 종료조건을 두었다.

import java.util.ArrayDeque;
import java.util.ArrayList;
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
    public static int m;
    public static int[][] grid;
    public static int[] dx = { 1, 0, -1, 0 };
    public static int[] dy = { 0, 1, 0, -1 };

    public static ArrayList<Pair> allStones = new ArrayList<>();
    public static ArrayList<Pair> startPoints = new ArrayList<>();

    public static int BFS() {
        int cnt = 0;
        Queue<Pair> q = new ArrayDeque<>();
        int[][] visited = new int[n][n];
        for (Pair startPoint : startPoints) {
            cnt++;
            visited[startPoint.x][startPoint.y] = 1;
            q.add(startPoint);
        }
        while (!q.isEmpty()) {
            Pair cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int x = cur.x + dx[i];
                int y = cur.y + dy[i];
                if (x < 0 || x >= n || y < 0 || y >= n || visited[x][y] == 1 || grid[x][y] == 1) {
                    continue;
                }
                cnt++;
                visited[x][y] = 1;
                q.add(new Pair(x, y));
            }
        }
        return cnt;
    }

    public static int mx;
    public static ArrayList<Pair> selectedStones = new ArrayList<>();

    public static void findMax(int idx, int it) {
        if (it == m) {
            for (Pair selectedStone : selectedStones) {
                grid[selectedStone.x][selectedStone.y] = 0;
            }
            mx = Math.max(mx, BFS());
            for (Pair selectedStone : selectedStones) {
                grid[selectedStone.x][selectedStone.y] = 1;
            }
            return;
        }
        if (idx >= allStones.size()) {
            return;
        }
        // 해설 종료조건
        // if(idx == (int) stonePos.size()) {
        // if(cnt == m)
        // ans = Math.max(ans, calc());
        // return;
        // }

        selectedStones.add(allStones.get(idx));
        findMax(idx + 1, it + 1);
        selectedStones.remove(selectedStones.size() - 1);
        findMax(idx + 1, it);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
                if (grid[i][j] == 1) {
                    allStones.add(new Pair(i, j));
                }
            }
        }
        for (int i = 0; i < k; i++) {
            startPoints.add(new Pair(sc.nextInt() - 1, sc.nextInt() - 1));
        }
        findMax(0, 0);
        System.out.println(mx);
    }
}