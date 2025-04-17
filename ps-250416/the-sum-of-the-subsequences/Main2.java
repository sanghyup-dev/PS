//n과m을 둘다 써서 공간복잡도로 시간복잡도 tradeoff시도

import java.util.Scanner;

public class Main2 {
    public static final int MAX_M = 10000;
    public static final int MAX_N = 100;

    // Variable declaration
    public static int n, m;
    public static int[] arr = new int[MAX_N + 1];

    // dp[i][j]: When considering up to the i-th number,
    // if it is possible to make the sum of the chosen numbers equal to j, then true
    // otherwise false
    public static boolean[][] dp = new boolean[MAX_N + 1][MAX_M + 1];

    public static void initialize() {
        // Define the initial condition
        // as the state where no numbers have been considered yet.
        // Therefore, considering up to the 0-th number,
        // the sum of the numbers chosen so far is 0,
        // so dp[0][0] = true.
        dp[0][0] = true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Input:
        n = sc.nextInt();
        m = sc.nextInt();
        for (int i = 1; i <= n; i++)
            arr[i] = sc.nextInt();

        initialize();

        // Consider up to the i-th number,
        // and determine if it is possible for the sum of the chosen numbers to be j.
        for (int i = 1; i <= n; i++) {
            // There are two main choices to create this situation.

            // Case 1
            // The case where the sum becomes j by selecting the i-th number.
            // In this case, the sum must be j including the i-th number,
            // so the sum of the numbers chosen up to the i-1-th must have been j - arr[i].
            // However, if j < arr[i], it is not possible to add the i-th number to make the
            // sum j,
            // so it is only possible when j >= arr[i].

            // Case 2
            // The case where the sum becomes j without selecting the i-th number.
            // In this case, the sum must be j excluding the i-th number,
            // so the sum of the numbers chosen up to the i-1-th must have been j.
            for (int j = 0; j <= m; j++) {
                // Case 1
                if (j >= arr[i] && dp[i - 1][j - arr[i]])
                    dp[i][j] = true;

                // Case 2
                if (dp[i - 1][j])
                    dp[i][j] = true;
            }
        }

        // After considering all n numbers,
        // determine if it is possible to make the sum exactly m.
        if (dp[n][m])
            System.out.print("Yes");
        else
            System.out.print("No");
    }
}