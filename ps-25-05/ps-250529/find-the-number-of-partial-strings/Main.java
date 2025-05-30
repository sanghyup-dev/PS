// https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-find-the-number-of-partial-strings/description
// mx를 -1로 설정해야 아무것도 해당안되는 경우 구할 수 있음! -> Parametric Search로 구해진 값+1이 답인 경우라 그럼
// A에 B의 마지막 char가 다시 나오는 경우 주의 -> early return 필요

import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static String A;
    public static String B;
    public static int n;
    public static int[] del;

    public static boolean isSub(HashSet toErase) {
        int cur = 0;
        for (int i = 0; i < A.length(); i++) {
            if (toErase.contains(i))
                continue;
            if (A.charAt(i) == B.charAt(cur)) {
                cur++;
                if (cur == B.length())
                    return true;
            }
        }
        return cur == B.length();
    }

    public static boolean possible(int cut) {
        HashSet<Integer> toErase = new HashSet<>();
        for (int i = 0; i < cut; i++) {
            toErase.add(del[i] - 1);
        }
        return isSub(toErase);
    }

    public static int pSearch() {
        int l = 0, r = n, mx = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (possible(mid)) {
                l = mid + 1;
                mx = Math.max(mx, mid);
            } else
                r = mid - 1;
        }
        return mx;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        A = sc.next();
        B = sc.next();
        n = A.length();
        del = new int[n];
        for (int i = 0; i < n; i++) {
            del[i] = sc.nextInt();
        }
        System.out.println(pSearch() + 1);
    }
}