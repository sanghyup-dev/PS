// https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-c-o-w/description

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        int[] CL = new int[n];
        int[] WR = new int[n];
        CL[0] = str.charAt(0) == 'C' ? 1 : 0;
        WR[n - 1] = str.charAt(n - 1) == 'W' ? 1 : 0;
        for (int i = 1; i < n; i++) {
            CL[i] = CL[i - 1] + (str.charAt(i) == 'C' ? 1 : 0);
        }
        for (int i = n - 2; i >= 0; i--) {
            WR[i] = WR[i + 1] + (str.charAt(i) == 'W' ? 1 : 0);
        }
        long ans = 0;
        for (int i = 1; i < n - 1; i++) {
            if (str.charAt(i) == 'O')
                ans += CL[i] * WR[i];

        }
        System.out.println(ans);
    }
}