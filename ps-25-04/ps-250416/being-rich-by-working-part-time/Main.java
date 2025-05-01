//https://www.codetree.ai/ko/trails/complete/curated-cards/test-being-rich-by-working-part-time/description

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static class PartTimeJob {
        int s;
        int e;
        int p;

        PartTimeJob(int s, int e, int p) {
            this.s = s;
            this.e = e;
            this.p = p;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<PartTimeJob> jobs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            jobs.add(new PartTimeJob(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }
        Collections.sort(jobs, (x, y) -> x.e - y.e);
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = jobs.get(i).p;
            int cur = i - 1;
            while (cur >= 0 && jobs.get(cur).e >= jobs.get(i).s) {
                dp[i] = Math.max(dp[i], dp[cur]);
                cur--;
            }
            if (cur >= 0)
                dp[i] = Math.max(dp[i], dp[cur] + jobs.get(i).p);
        }

        System.out.println(dp[n - 1]);
    }
}