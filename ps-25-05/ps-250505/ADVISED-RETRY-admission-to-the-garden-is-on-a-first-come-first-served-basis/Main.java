
// https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-admission-to-the-garden-is-on-a-first-come-first-served-basis/description
// what might go wrong will go wrong. 철저하게 케이스 나누어 구조 짜고 코딩 시작하기

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static class Visitor {
        int ticketNo;
        int enterTime;
        int duration;

        Visitor(int n, int t, int d) {
            ticketNo = n;
            enterTime = t;
            duration = d;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Queue<Visitor> visitors = new PriorityQueue<>((x, y) -> {
            if (x.enterTime == y.enterTime)
                return x.ticketNo - y.ticketNo;
            return x.enterTime - y.enterTime;
        });
        Queue<Visitor> waiting = new PriorityQueue<>((x, y) -> x.ticketNo - y.ticketNo);

        for (int i = 1; i <= n; i++) {
            visitors.add(new Visitor(i, sc.nextInt(), sc.nextInt()));
        }

        int mxDur = 0;
        int curTime = visitors.peek().enterTime + visitors.poll().duration;
        while (true) {
            while (!visitors.isEmpty() && visitors.peek().enterTime <= curTime) {
                Visitor v = visitors.poll();
                waiting.add(v);
            }
            Visitor v;
            if (!waiting.isEmpty()) {
                v = waiting.poll();
                mxDur = Math.max(mxDur, curTime - v.enterTime);
                curTime += v.duration;

            } else {
                if (!visitors.isEmpty()) {
                    v = visitors.poll();
                    curTime = v.enterTime + v.duration;
                } else
                    break;
            }

        }
        System.out.println(mxDur);
    }
}