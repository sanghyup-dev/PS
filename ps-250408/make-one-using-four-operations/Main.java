
//https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-make-one-using-four-operations/description
//아래처럼 후보를 먼저 생성하고 조건 검사 등 하는 것이 머리 안아플 듯
//조건 달성 검사에 두가지 방법이 있을 듯: 1. 후보를 검사 2. 큐에서 poll한 결과를 검사
//후보를 검사할때 초기의 입력값은 검사가 안되는 것 주의! 초기화 단계에서 해야함!
//step의 범위도 생각해볼만한 가치가 있음: 최악 케이스: -1로 끝까지 가는 것 따라서 2000001까지만 설정해도 됐었음.
//음수는 고려할 필요 없는게 맞는듯.

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static int n;
    public static int[] step = new int[3000001];

    public static void BFS() {
        Queue<Integer> q = new ArrayDeque<>();
        step[n] = 1;
        q.add(n);

        while (!q.isEmpty()) {
            int ci = q.poll();
            if (ci == 1) {
                System.out.println(step[ci] - 1);
                System.exit(0);
            }

            List<Integer> candidiates = new ArrayList<>();

            if (ci % 3 == 0) {
                candidiates.add(ci / 3);
            }
            if (ci % 2 == 0) {
                candidiates.add(ci / 2);
            }
            candidiates.add(ci - 1);
            candidiates.add(ci + 1);

            for (Integer candidiate : candidiates) {
                if (step[candidiate] != 0) {
                    continue;
                }
                step[candidiate] = step[ci] + 1;
                q.add(candidiate);
            }

        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        BFS();
    }
}