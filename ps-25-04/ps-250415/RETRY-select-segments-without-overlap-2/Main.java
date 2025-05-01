//https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-select-segments-without-overlap-2/description
//그리디의 정석적인 문제. dp로도 해결 가능

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static class Line {
        int start;
        int end;

        Line(int s, int e) {
            start = s;
            end = e;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Line> segments = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            segments.add(new Line(sc.nextInt(), sc.nextInt()));
        }
        Collections.sort(segments, (a, b) -> a.end - b.end);

        int cnt = 0;
        int idx = -1;

        for (Line line : segments) {
            if (line.start > idx) {
                cnt++;
                idx = line.end;
            }
        }
        System.out.println(cnt);
    }
}

// //alternative solution (DP-> bruteforce+memoization)
// import java.util.Scanner;
// import java.util.Arrays;

// class Segment implements Comparable<Segment> {
// int x1, x2;

// public Segment() {
// }

// public Segment(int x1, int x2) {
// this.x1 = x1;
// this.x2 = x2;
// }

// @Override
// public int compareTo(Segment s) {
// // Sort in ascending order based on x1.
// return this.x1 - s.x1;
// }
// }

// public class Main {
// public static final int MAX_N = 1000;

// // Variable declaration
// public static int n;
// public static Segment[] segments = new Segment[MAX_N];

// // dp[i]: Assuming sorted by x1,
// // the maximum number of non-overlapping segments
// // that can be selected ending with the i-th segment
// public static int[] dp = new int[MAX_N];

// public static void main(String[] args) {
// Scanner sc = new Scanner(System.in);
// // Input:
// n = sc.nextInt();
// for(int i = 0; i < n; i++) {
// int x1 = sc.nextInt();
// int x2 = sc.nextInt();
// segments[i] = new Segment(x1, x2);
// }

// // Sort in ascending order based on x1.
// Arrays.sort(segments, 0, n);

// for(int i = 0; i < n; i++) {
// // When the current segment is the starting segment,
// // the dp value becomes 1,
// // so the initial setting is 1.
// dp[i] = 1;

// // Before selecting the i-th segment,
// // assuming the immediately selected segment is j,
// // calculate the maximum number of segments that can be selected
// // among the non-overlapping segments i and j.
// for(int j = 0; j < i; j++) {
// int x1I = segments[i].x1;
// int x2J = segments[j].x2;

// // Since it is already sorted by x1,
// // as long as x2[j] < x1[i], the two segments do not overlap.
// if(x2J < x1I)
// dp[i] = Math.max(dp[i], dp[j] + 1);
// }
// }

// // Among the cases where the last selected segment position is i,
// // choose the case with the largest number of selectable segments.
// int ans = 0;
// for(int i = 0; i < n; i++)
// ans = Math.max(ans, dp[i]);

// System.out.print(ans);
// }
// }
