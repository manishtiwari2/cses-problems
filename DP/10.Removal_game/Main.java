import java.io.*;
import java.util.*;
 
public class Main {
    public static void main(String[] args) throws Exception {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
 
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        long[][] dp = new long[n][n];
 
        for (long[] row : dp) {
            Arrays.fill(row, Long.MIN_VALUE);
        }
        System.out.println(solve(arr, 0, n - 1, dp));
    }
 
    private static long solve(int[] arr, int i, int j, long[][] dp) {
 
        if (i > j) {
            return 0;
        }
 
        if (i == j) {
            return arr[i];
        }
 
        if (dp[i][j] != Long.MIN_VALUE) {
            return dp[i][j];
        }
 
        long left = arr[i] + Math.min(
            solve(arr, i + 2, j, dp),
            solve(arr, i + 1, j - 1, dp)
        );
 
        long right = arr[j] + Math.min(
            solve(arr, i + 1, j - 1, dp),
            solve(arr, i, j - 2, dp)
        );
 
        return dp[i][j] = Math.max(left, right);
    }
}