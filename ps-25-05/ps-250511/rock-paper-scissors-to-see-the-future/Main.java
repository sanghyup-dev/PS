// https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-rock-paper-scissors-to-see-the-future/description

import java.util.Scanner;

public class Main {

    public static boolean isWin(char A, char B) {
        return (A == 'H' && B == 'S') ||
                (A == 'S' && B == 'P') ||
                (A == 'P' && B == 'H');
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[] matches = new char[n + 1];
        for (int i = 1; i < n + 1; i++) {
            matches[i] = sc.next().charAt(0);
        }

        int[] HL = new int[n + 2];
        int[] SL = new int[n + 2];
        int[] PL = new int[n + 2];
        int[] HR = new int[n + 2];
        int[] SR = new int[n + 2];
        int[] PR = new int[n + 2];

        for (int i = 1; i < n; i++) {
            HL[i] = HL[i - 1] + (isWin('H', matches[i]) ? 1 : 0);
            SL[i] = SL[i - 1] + (isWin('S', matches[i]) ? 1 : 0);
            PL[i] = PL[i - 1] + (isWin('P', matches[i]) ? 1 : 0);
        }
        for (int i = n; i > 0; i--) {
            HR[i] = HR[i + 1] + (isWin('H', matches[i]) ? 1 : 0);
            SR[i] = SR[i + 1] + (isWin('S', matches[i]) ? 1 : 0);
            PR[i] = PR[i + 1] + (isWin('P', matches[i]) ? 1 : 0);
        }
        int mx = 0;
        for (int i = 1; i < n; i++) {
            mx = Math.max(mx, HL[i] + HR[i + 1]);
            mx = Math.max(mx, HL[i] + SR[i + 1]);
            mx = Math.max(mx, HL[i] + PR[i + 1]);
            mx = Math.max(mx, SL[i] + HR[i + 1]);
            mx = Math.max(mx, SL[i] + SR[i + 1]);
            mx = Math.max(mx, SL[i] + PR[i + 1]);
            mx = Math.max(mx, PL[i] + HR[i + 1]);
            mx = Math.max(mx, PL[i] + SR[i + 1]);
            mx = Math.max(mx, PL[i] + PR[i + 1]);
        }
        System.out.println(mx);
    }
}