// https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-maximum-consecutive-number/description
// TreeSet은 compareTo()가 0을 반환하면 같은 객체로 간주하여 중복을 허용하지 않는다.
// .equals()를 기준으로 하지 않는다. 따라서 compareTo()가 독립된 개체를 제거하지 않도록 짜야한다.

import java.util.Scanner;
import java.util.TreeSet;

public class Main {

    public static class ChunkStart implements Comparable<ChunkStart> {
        int start;
        int end;
        int length;

        ChunkStart(int s, int e) {
            start = s;
            end = e;
            length = e - s + 1;
        }

        @Override
        public int compareTo(Main.ChunkStart o) {
            return this.start - o.start;
        }

    }

    public static class ChunkLength implements Comparable<ChunkLength> {
        int start;
        int end;
        int length;

        ChunkLength(int s, int e) {
            start = s;
            end = e;
            length = e - s + 1;
        }

        @Override
        public int compareTo(Main.ChunkLength o) {
            if (this.length != o.length)
                return this.length - o.length;
            return this.start - o.start;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        TreeSet<ChunkLength> longest = new TreeSet<>();
        TreeSet<ChunkStart> order = new TreeSet<>();

        longest.add(new ChunkLength(0, n));
        order.add(new ChunkStart(0, n));

        for (int i = 0; i < m; i++) {
            int cut = sc.nextInt();
            ChunkStart chunk = order.floor(new ChunkStart(cut, -1));
            int start = chunk.start;
            int end = chunk.end;
            order.remove(chunk);
            longest.remove(new ChunkLength(start, end));
            if (start != cut) {
                order.add(new ChunkStart(start, cut - 1));
                longest.add(new ChunkLength(start, cut - 1));
            }
            if (end != cut) {
                order.add(new ChunkStart(cut + 1, end));
                longest.add(new ChunkLength(cut + 1, end));
            }

            System.out.println(longest.last().length);
        }
    }
}