import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        // Fast input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // Read number n
        
        int[] dp = new int[n + 1]; // dp[i] = minimum steps needed to reduce i to 0

        // Fill with a large value initially because we want to find minimum
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0; // Base case: 0 steps are needed to reduce 0 to 0

        // Calculate answer for every number from 1 to n
        for (int i = 1; i <= n; i++) {
            // Copy i because we will extract its digits
            int num = i;
            while (num > 0) {
                int digit = num % 10;
                // Ignore digit 0 because subtracting 0 changes nothing
                if (digit != 0) {

                    /*
                     * From number i, subtract the current digit. New number = i - digit
                     * dp[i - digit] = minimum steps needed to reduce the remaining number to 0.
                     * +1 = current subtraction step Take minimum among all possible digits.
                     */
                    dp[i] = Math.min(dp[i], dp[i - digit] + 1);
                }
                num /= 10;
            }
        }
        System.out.println(dp[n]);
    }
}