import java.io.*;

public class Main {

    // We take modulo because the answer can become very large
    private static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws Exception {

        // Read input
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );
        int n = Integer.parseInt(br.readLine().trim());

        // dp[i] = number of ways to make sum i
        int[] dp = new int[n + 1];

        // Base case: There is exactly 1 way to make sum 0: Choose nothing
        dp[0] = 1;

        // Calculate answer for every sum from 1 to n
        for (int sum = 1; sum <= n; sum++) {
            // Try every possible dice value: 1, 2, 3, 4, 5, 6
            for (int dice = 1; dice <= 6; dice++) {

                // If this dice value can be used
                if (sum - dice >= 0) {

                    /*
                     * To make 'sum', suppose we choose 'dice' as the last dice. Then before choosing this dice,
                     * we must make the remaining sum: sum - dice, So: dp[sum] += dp[sum - dice]
                     * This is the main DP pattern: Current Answer += Previous Smaller Subproblem
                     */
                    dp[sum] = (dp[sum] + dp[sum - dice]) % MOD;
                }
            }
        }
        // dp[n] = number of ways to make sum n
        System.out.println(dp[n]);
    }
}

// ### Quick DP revision pattern

// Remember this:

// > **Define → Base Case → Try Choices → Find Previous State → Build Current Answer**

// For this problem:

// - **State:** `dp[sum]` = ways to make `sum`
// - **Choice:** choose dice from `1` to `6`
// - **Transition:** `dp[sum] += dp[sum - dice]`
// - **Base case:** `dp[0] = 1`
// - **Answer:** `dp[n]`

// The most important intuition is:
// **"What can I choose last?"**

// If the last dice is `dice`, then the remaining problem is `sum - dice`.
//  This **"choose the last move and reduce to a smaller subproblem"** pattern appears in many DP problems.

