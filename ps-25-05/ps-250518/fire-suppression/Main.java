// https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-fire-suppression/description

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] fires = new int[n];
        int[] stations = new int[m];
        for (int i = 0; i < n; i++)
            fires[i] = sc.nextInt();
        for (int i = 0; i < m; i++)
            stations[i] = sc.nextInt();

        int[] distance = new int[n];

        Arrays.sort(fires);
        Arrays.sort(stations);

        for (int i = 0; i < distance.length; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        int station = 0;
        for (int fire = 0; fire < n; fire++) {
            while (station + 1 < m && stations[station + 1] < fires[fire]) {
                station++;
            }

            if (stations[station] < fires[fire]) {
                distance[fire] = fires[fire] - stations[station];
            }
        }

        for (int fire : distance) {
            System.out.print(fire + " ");
        }
        System.out.println();
        station = m - 1;
        for (int fire = n - 1; fire >= 0; fire--) {
            while (station - 1 >= 0 && stations[station - 1] > fires[fire]) {
                station--;
            }

            if (stations[station] > fires[fire]) {
                distance[fire] = Math.min(distance[fire], stations[station] - fires[fire]);
            }
        }

        int mx = 0;

        for (int i : distance) {
            mx = Math.max(mx, i);
        }
        System.out.println(mx);
    }
}