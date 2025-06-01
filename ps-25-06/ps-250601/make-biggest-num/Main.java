// https://www.codetree.ai/ko/trails/complete/curated-cards/intro-make-biggest-num/description

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr, (a, b) -> {
            return Long.compare(Long.parseLong(b + "" + a), Long.parseLong(a + "" + b));
        });

        for (int i : arr) {
            System.out.print(i);
        }

    }
}