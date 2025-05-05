// https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-problem-recommendation-system-1/description

import java.util.Scanner;
import java.util.TreeSet;

public class Main {

    public static class Question implements Comparable<Question> {
        int level;
        int problem;

        Question(int p, int l) {
            level = l;
            problem = p;
        }

        @Override
        public int compareTo(Main.Question o) {
            if (this.level != o.level)
                return this.level - o.level;
            else
                return this.problem - o.problem;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeSet<Question> set = new TreeSet<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int p = sc.nextInt();
            int l = sc.nextInt();
            set.add(new Question(p, l));

        }
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            String command = sc.next();
            if (command.equals("rc")) {
                int x = sc.nextInt();
                if (x == -1) {
                    System.out.println(set.first().problem);
                } else
                    System.out.println(set.last().problem);
            } else if (command.equals("ad") || command.equals("sv")) {
                int p = sc.nextInt();
                int l = sc.nextInt();
                if (command.equals("ad")) {
                    set.add(new Question(p, l));
                } else {
                    set.remove(new Question(p, l));
                }
            }
        }
    }
}