import java.io.*;

public class Main1 {

    static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        // Read grid size
        int n = Integer.parseInt(br.readLine().trim());

        // Store the grid (using 1-based indexing)
        char[][] grid = new char[n + 1][n + 1];

        // Read each row of the grid
        for (int i = 0; i <= n; i++) {
            grid[i] = br.readLine().toCharArray();
        }

        // dp[i][j] = number of ways to reach cell (i, j)
        int[][] dp = new int[n + 1][n + 1];

        // Start with 1 way if starting cell is not blocked
        if (grid[1][1] != '*') {
            dp[1][1] = 1;
        }

        // Calculate paths for every cell
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {

                // Starting cell is already initialized
                if (i == 1 && j == 1) continue;

                // Cannot reach a blocked cell
                if (grid[i][j] == '*') {
                    dp[i][j] = 0;
                    continue;
                }

                // Add paths coming from the top
                if (i > 1) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j]) % MOD;
                }

                // Add paths coming from the left
                if (j > 1) {
                    dp[i][j] = (dp[i][j] + dp[i][j - 1]) % MOD;
                }
            }
        }
        System.out.println(dp[n][n]);
    }
}