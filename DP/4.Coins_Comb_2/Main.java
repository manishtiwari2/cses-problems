import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws Exception {

        // Faster input than Scanner
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read first line: n and x
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());   // n = number of coins
        int x = Integer.parseInt(st.nextToken());   // x = target sum

        int[] coins = new int[n];   // Store all coin values

        st = new StringTokenizer(br.readLine()); // Read the line containing coins

        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[x + 1];   // dp[i] = number of ways to make sum i

        // Base case: There is exactly 1 way to make sum 0 -> choose no coins
        dp[0] = 1;

        // Process one coin at a time
        for (int coin : coins) {
            // Try to make every target using the current coin
            for (int target = coin; target <= x; target++) {

                /*
                 * To make 'target', use the current coin.
                 * Remaining sum = target - coin, dp[target - coin] tells us how many ways
                 * exist to make the remaining sum. Add those ways to dp[target].
                 */
                dp[target] = (dp[target] + dp[target - coin]) % MOD;
            }
        }

        // dp[x] = total number of ways to make target x
        System.out.println(dp[x]);
    }
}