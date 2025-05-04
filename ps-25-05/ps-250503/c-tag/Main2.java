//독자적 클라스를 만들지 않은 풀이

import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 그룹당 종이 수
        int m = sc.nextInt(); // 알파벳 길이

        String[] A = new String[n];
        String[] B = new String[n];
        for (int i = 0; i < n; i++)
            A[i] = sc.next();
        for (int i = 0; i < n; i++)
            B[i] = sc.next();

        int count = 0;

        // 서로 다른 세 자리 조합 (i < j < k)
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                for (int k = j + 1; k < m; k++) {
                    Set<String> aSet = new HashSet<>();
                    for (int t = 0; t < n; t++) {
                        aSet.add("" + A[t].charAt(i) + A[t].charAt(j) + A[t].charAt(k));
                    }

                    boolean isValid = true;
                    for (int t = 0; t < n; t++) {
                        String comb = "" + B[t].charAt(i) + B[t].charAt(j) + B[t].charAt(k);
                        if (aSet.contains(comb)) {
                            isValid = false;
                            break;
                        }
                    }

                    if (isValid)
                        count++;
                }
            }
        }

        System.out.println(count);
    }
}
