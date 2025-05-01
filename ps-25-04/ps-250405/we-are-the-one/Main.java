//https://www.codetree.ai/ko/trails/complete/curated-cards/test-we-are-the-one/description
//clear-stones-well과 동일한 방식으로 종료조건이 형성된 건 맞지만 구현 형태가 다르다.
//clear-stones-well의 경우 끝없이 나아가다 종료조건에서 확인하고 아래 코드는 함수마다 끝이 명확이 정해져있다.
//증복 선정 방지를 위해 backtracking에서 Y+1로 다음 탐색을 사용했는데 이때 시작을 0,0으로 하기 위해서는 init을 0,0,-1로 해야한다.

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
    public static int k;
    public static int u;
    public static int d;
    public static int[][] grid;

    public static List<Pair> selectedCities = new ArrayList<>();

    public static int dfs() {
        int cnt = 0;
        int[][] visited = new int[n][n];
        Queue<Pair> q = new ArrayDeque<>();

        for (Pair selectedCity : selectedCities) {
            visited[selectedCity.x][selectedCity.y] = 1;
            cnt++;
            q.add(selectedCity);
        }

        while (!q.isEmpty()) {
            int cx = q.peek().x;
            int cy = q.poll().y;

            for (int i = 0; i < 4; i++) {
                int x = cx + dx[i];
                int y = cy + dy[i];

                if (x < 0 || x >= n || y < 0 || y >= n || visited[x][y] == 1) {
                    continue;
                }
                int diff = Math.abs(grid[x][y] - grid[cx][cy]);
                if (diff > d || diff < u) {
                    continue;
                }

                visited[x][y] = 1;
                cnt++;
                q.add(new Pair(x, y));
            }
        }

        return cnt;
    }

    public static int mx;

    public static void findMax(int it, int x, int y) {
        if (it == k) {
            mx = Math.max(mx, dfs());
            return;
        }
        for (int i = y + 1; i < n; i++) {
            selectedCities.add(new Pair(x, i));
            findMax(it + 1, x, i);
            selectedCities.remove(selectedCities.size() - 1);
        }
        for (int i = x + 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                selectedCities.add(new Pair(i, j));
                findMax(it + 1, i, j);
                selectedCities.remove(selectedCities.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        u = sc.nextInt();
        d = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        findMax(0, 0, -1);
        System.out.println(mx);
    }
}
