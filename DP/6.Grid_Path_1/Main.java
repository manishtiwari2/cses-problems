import java.io.*;
import java.util.Arrays;

public class Main {

    static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        char[][] grid = new char[n][n];

        for (int i = 0; i < n; i++) {
            grid[i] = br.readLine().toCharArray();
        }
        int[][] dp =  new int[n][n];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }

        System.out.println(paths(grid, 0, 0, n, dp));
    }

    private static int paths(char[][] grid, int i, int j, int n, int[][] dp) {
        if (i >= n || i < 0 || j >= n || j < 0 || grid[i][j] == '*') {
            return 0;
        }
        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        if (i == n - 1 && j == n - 1) {
            return 1;
        }

        int pathFromDown = paths(grid, i + 1, j, n, dp);
        int pathFromRight = paths(grid, i, j + 1, n, dp);

        return dp[i][j] = (pathFromDown + pathFromRight) % MOD;
    }
}