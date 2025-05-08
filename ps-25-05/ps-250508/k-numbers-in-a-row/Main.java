// https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-k-numbers-in-a-row/description

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int b = sc.nextInt();
        List<Integer> missingNumbers = new ArrayList<>();
        missingNumbers.add(0);
        for (int i = 0; i < b; i++) {
            missingNumbers.add(sc.nextInt());
        }
        missingNumbers.add(n + 1);
        missingNumbers.sort(null);

        int s = 0;
        int e = 0;
        int ans = Integer.MAX_VALUE;
        while (true) {
            if (missingNumbers.get(e) - missingNumbers.get(s) - 1 >= k) {
                int erased = e - s - 1;
                ans = Math.min(ans, erased);
                if (s != b + 1)
                    s++;
                else
                    break;
            }
            if (missingNumbers.get(e) - missingNumbers.get(s) - 1 < k) {
                if (e != b + 1)
                    e++;
                else
                    break;
            }
        }
        System.out.println(ans);
    }
}