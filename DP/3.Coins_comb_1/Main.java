import java.io.*;
import java.util.*;

public class Main {

    static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws Exception {

        // Faster input than Scanner
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        // Read first line: n and x
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        // Store all coin values
        int[] coins = new int[n];

        // Read second line containing coins
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(st.nextToken());
        }

        // dp[i] = number of ways to make sum i
        int[] dp = new int[x + 1];

        // Base case:
        // There is exactly 1 way to make sum 0:
        // choose nothing
        dp[0] = 1;

        // Calculate number of ways for every target
        for (int target = 1; target <= x; target++) {

            // Try every coin as the last coin
            for (int coin : coins) {
                // Coin can be used only if it is <= target
                if (coin <= target) {

                    /*
                     * If we choose 'coin' last, then we need to make:
                     * target - coin Add all ways of making the remaining target.
                     */
                    dp[target] = (dp[target] + dp[target - coin]) % MOD;
                }
            }
        }
        // Number of ways to make sum x
        System.out.println(dp[x]);
    }
}

// ### Important DP observation

// Your loop order is:

// ```java
// for (target = 1 ...)
//     for (coin : coins)
// ````

// This means **order matters**.

// For example, with coins `{1, 2}` and target `3`:

// * `1 + 2`
// * `2 + 1`

// are counted as **different ways**.

// This is the pattern used in **CSES Coin Combinations I**.

// If you reverse the loops:

// ```java
// for (coin : coins)
//     for (target = coin ...)
// ```

// then order does **not** matter.

// That loop-order difference is extremely important in DP and worth remembering.
