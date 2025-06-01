
// https://www.codetree.ai/ko/trails/complete/curated-cards/intro-implement-fractional-knapsack/description
// printf("%.3f"..는 자동 반올림임 (버림 X)
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {

    static class Jewel {
        int w;
        int v;

        Jewel(int w, int v) {
            this.w = w;
            this.v = v;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<Jewel> jewels = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            jewels.add(new Jewel(sc.nextInt(), sc.nextInt()));
        }

        Collections.sort(jewels, (x, y) -> {
            return Double.compare(y.v / (double) y.w, x.v / (double) x.w);
        });
        double sum = 0;
        int weight = 0;
        Iterator<Jewel> it = jewels.iterator();
        while (weight < m) {
            if (it.hasNext()) {
                Jewel j = it.next();
                if (weight + j.w <= m) {
                    sum += j.v;
                    weight += j.w;
                } else {
                    sum += (m - weight) * (j.v / (double) j.w);
                    break;
                }
            } else
                break;
        }
        System.out.printf("%.3f", sum);
    }
}