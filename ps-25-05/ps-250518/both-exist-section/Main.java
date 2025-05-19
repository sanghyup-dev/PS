// https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-both-exist-section/description

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];

        HashMap<Integer, Integer> house = new HashMap<>();

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            house.put(arr[i], house.getOrDefault(arr[i], 0) + 1);
        }

        if (house.size() != m) {
            System.out.println(-1);
            return;
        }

        int mn = Integer.MAX_VALUE;
        HashSet<Integer> handSet = new HashSet<>();
        HashMap<Integer, Integer> hand = new HashMap<>();

        int l = 0;
        while (house.get(arr[l]) == 1)
            l++;

        int r = l;
        house.put(arr[l], house.get(arr[l]) - 1);
        handSet.add(arr[l]);
        hand.put(arr[l], 1);

        // System.out.println("start : " + l + " " + r);

        for (; l < n; l++) {
            // System.out.println("moving l : " + l + " " + r);

            while (r + 1 < n && house.get(arr[r + 1]) != 1 && handSet.size() < m) {
                // System.out.println("moving r : " + l + " " + r);
                house.put(arr[r + 1], house.get(arr[r + 1]) - 1);
                hand.put(arr[r + 1], hand.getOrDefault(arr[r + 1], 0) + 1);
                handSet.add(arr[r + 1]);
                r++;
            }
            if (l > r) {
                System.out.println(-1);
                // System.out.println("err: l>r : " + l + " " + r);
                return;
            }

            if (handSet.size() == m) {
                mn = Math.min(mn, r - l + 1);
            }

            house.put(arr[l], house.get(arr[l]) + 1);
            int inHand = hand.get(arr[l]);
            if (inHand == 1) {
                hand.remove(arr[l]);
                handSet.remove(arr[l]);
            } else {
                hand.put(arr[l], hand.getOrDefault(arr[l], 0) - 1);
            }
        }
        if (mn == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(mn);
    }
}