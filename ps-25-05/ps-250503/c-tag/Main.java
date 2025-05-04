// https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-c-tag/description
// does not need custom class ! just use string!

import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static class Combination {
        char a;
        char b;
        char c;

        Combination(char a, char b, char c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public boolean equals(Object obj) {
            Combination that = (Combination) obj;
            if (this.a == that.a && this.b == that.b && this.c == that.c)
                return true;
            else
                return false;
        }

        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode += (int) a * 10000;
            hashCode += (int) b * 100;
            hashCode += (int) c * 1;
            return hashCode;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String[] groupA = new String[n];
        String[] groupB = new String[n];
        for (int i = 0; i < n; i++) {
            groupA[i] = sc.next();
        }
        for (int i = 0; i < n; i++) {
            groupB[i] = sc.next();
        }
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                for (int j2 = j + 1; j2 < m; j2++) {
                    HashSet<Combination> combinations = new HashSet<>();
                    boolean isAns = true;
                    for (int k = 0; k < n; k++) {
                        combinations
                                .add(new Combination(groupA[k].charAt(i), groupA[k].charAt(j), groupA[k].charAt(j2)));
                    }
                    for (int k = 0; k < n; k++) {
                        Combination check = new Combination(groupB[k].charAt(i), groupB[k].charAt(j),
                                groupB[k].charAt(j2));
                        if (combinations.contains(check)) {
                            isAns = false;
                            break;
                        }
                    }
                    cnt += isAns ? 1 : 0;
                }
            }
        }
        System.out.println(cnt);
    }
}