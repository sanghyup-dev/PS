// https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-horizontal-track-with-infinite-length/description
// 끝이 어떻게 되는지 보고 그를 기준으로 한다.
// Main2 읽어보기

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long t = sc.nextLong();

        long[] finalPositions = new long[n];

        for (int i = 0; i < n; i++) {
            long start = sc.nextLong();
            long speed = sc.nextLong();
            finalPositions[i] = start + speed * t;
        }

        int groups = 0;
        long lastPos = Long.MAX_VALUE;

        // 역순으로 탐색하며 그룹 개수 셈
        for (int i = n - 1; i >= 0; i--) {
            if (finalPositions[i] < lastPos) {
                groups++;
                lastPos = finalPositions[i];
            }
        }

        System.out.println(groups);
    }
}
