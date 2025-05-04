// https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-changing-seats-2/description

import java.util.Scanner;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] seats = new int[n + 1];
        List<HashSet<Integer>> ans = new ArrayList<>();
        ans.add(null);
        for (int i = 1; i <= n; i++) {
            seats[i] = i;
            ans.add(new HashSet<Integer>());
            ans.get(i).add(i);
        }
        int[] firsts = new int[3 * k];
        int[] seconds = new int[3 * k];

        for (int i = 0; i < k; i++) {
            firsts[i] = sc.nextInt();
            seconds[i] = sc.nextInt();
        }
        for (int it = 0; it < 3; it++) {
            for (int i = 0; i < k; i++) {
                int first = firsts[i];
                int second = seconds[i];
                int tmp;
                tmp = seats[first];
                seats[first] = seats[second];
                seats[second] = tmp;
                ans.get(seats[first]).add(first);
                ans.get(seats[second]).add(second);
            }

        }
        boolean passZero = true;
        for (HashSet<Integer> set : ans) {
            if (passZero) {
                passZero = false;
                continue;
            }
            System.out.println(set.size());
        }

    }
}