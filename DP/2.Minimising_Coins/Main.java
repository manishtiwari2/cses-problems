import java.util.*;
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // n = number of coin types
        // x = target sum
        int n = sc.nextInt();
        int x = sc.nextInt();

        int[] coins = new int[n];

        // Read all coin values
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        // dp[i] = minimum number of coins needed to make sum i
        int[] dp = new int[x + 1];

        // Initially, assume all sums are impossible
        // We use a large value as infinity
        Arrays.fill(dp, Integer.MAX_VALUE);

        // Base case:
        // To make sum 0, we need 0 coins
        dp[0] = 0;

        // Calculate answer for every sum from 1 to x
        for (int sum = 1; sum <= x; sum++) {
            for (int coin : coins) {
                // Check if this coin can be used
                if (sum - coin >= 0 && dp[sum - coin] != Integer.MAX_VALUE) {

                    /*
                     * Suppose 'coin' is the last coin we choose. Then we need to make: sum - coin
                     * dp[sum - coin] tells us the minimum coinsneeded for the remaining sum.
                     * +1 because we are using the current coin. We take minimum among all possible coins.
                     */
                    dp[sum] = Math.min(dp[sum], dp[sum - coin] + 1);
                }
            }
        }

        // If dp[x] is still infinity, it means target sum cannot be formed
        if (dp[x] == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(dp[x]);
        }

        sc.close();
    }
}

// ## DP pattern to remember

// This problem is very similar to your previous Dice Combinations problem.

// ### 1. State

// ```java
// dp[i] = minimum coins needed to make sum i
// ````

// ### 2. Base case

// ```java
// dp[0] = 0
// ```

// To make sum `0`, we need `0` coins.

// ### 3. Choice

// Try every coin:

// ```java
// for (int coin : coins)
// ```

// ### 4. Transition

// Think:

// > **"If this coin is my last choice, what was the previous problem?"**

// Previous sum:

// ```text
// sum - coin
// ```

// So:

// ```text
// dp[sum] = min(dp[sum], dp[sum - coin] + 1)
// ```

// ### Key difference from Dice DP

// | Problem           | Meaning of dp            | Transition |
// | ----------------- | ------------------------ | ---------- |
// | Dice Combinations | Number of ways           | `+=`       |
// | Minimum Coins     | Minimum operations/coins | `min()`    |

// This is an important DP pattern:

// > **Count ways → usually add (`+`)**
// > **Find minimum → use `min()`**
// > **Find maximum → use `max()`**
