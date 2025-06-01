// https://www.codetree.ai/ko/trails/complete/curated-cards/intro-implement-scheduling-meeting-room/description

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static class Meeting {
        int s;
        int e;

        Meeting(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Meeting> l = new ArrayList<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            l.add(new Meeting(sc.nextInt(), sc.nextInt()));
        }
        Collections.sort(l, (x, y) -> {
            if (x.e == y.e) {
                return x.s - y.e;
            } else
                return x.e - y.e;
        });

        int last = 0;
        int cnt = 0;

        for (Meeting m : l) {
            if (m.s >= last) {
                last = m.e;
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}