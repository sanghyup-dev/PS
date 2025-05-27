// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AY9QUhl6cfQDFAVF

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Solution {

    public static void make(Stack<Integer> stack) {
        while (!stack.isEmpty()) {
            int i = stack.pop();
            cnt++;
            inorder[i] = true;
            sb.append(i).append(' ');
        }
        sb.append(n + 1).append(' ');
        cnt++;
    }

    public static void sort(int i) {
        Stack<Integer> s = new Stack<>();
        int nxt = nums[i];
        s.add(nxt);
        while (s.peek() != i) {
            nxt = nums[nxt];
            s.add(nxt);
        }
        make(s);
    }

    public static int[] nums;
    public static int n;
    public static boolean[] inorder;
    public static int cnt;
    public static StringBuilder sb;

    public static void main(String args[]) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T = Integer.parseInt(bf.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            n = Integer.parseInt(bf.readLine());
            nums = new int[n + 2];
            inorder = new boolean[n + 1];
            cnt = 0;
            sb = new StringBuilder();
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int i = 1; i <= n; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }

            inorder[0] = true;

            for (int i = 1; i <= n; i++) {
                if (i == nums[i]) {
                    inorder[i] = true;
                }
            }
            for (int i = 1; i <= n; i++) {
                if (!inorder[i] && i != nums[i]) {
                    sort(i);
                }
            }
            System.out.println(cnt);
            System.out.println(sb.toString());
        }
    }
}