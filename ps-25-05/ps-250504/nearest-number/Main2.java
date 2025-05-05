import java.util.Scanner;
import java.util.TreeSet;

public class Main2 {
    public static int diff(Integer a, Integer b) {
        if (a == null || b == null)
            return Integer.MAX_VALUE;
        return Math.abs(a - b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        TreeSet<Integer> set = new TreeSet<>();

        set.add(0);
        int MinDis = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int p = sc.nextInt();
            set.add(p);
            Integer rDist = set.higher(p);
            Integer lDist = set.lower(p);
            MinDis = Math.min(MinDis, diff(p, rDist));
            MinDis = Math.min(MinDis, diff(p, lDist));
            System.out.println(MinDis);
        }
    }
}