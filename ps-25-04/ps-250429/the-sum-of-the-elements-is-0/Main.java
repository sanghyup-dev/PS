//https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-the-sum-of-the-elements-is-0/description
//입력을 굳이 바로 hashmap에 넣을 필요 없음. 공간이 허용한다면 다양한 형태의 자료구조간 변환을 고려해봐라.

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n];
        int[] B = new int[n];
        int[] C = new int[n];
        int[] D = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            B[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            C[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            D[i] = sc.nextInt();
        }
        HashMap<Integer, Integer> first = new HashMap<>();
        HashMap<Integer, Integer> second = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                first.put(A[i] + B[j], first.getOrDefault(A[i] + B[j], 0) + 1);
            }
        }
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                second.put(C[i] + D[j], second.getOrDefault(C[i] + D[j], 0) + 1);
            }
        }
        int ans = 0;
        for (Map.Entry<Integer, Integer> i : first.entrySet()) {
            if (second.containsKey(0 - i.getKey())) {
                ans += second.get(0 - i.getKey()) * i.getValue();
            }
        }
        System.out.println(ans);
    }
}