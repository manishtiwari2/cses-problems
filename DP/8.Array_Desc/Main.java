import java.io.*;
import java.util.*;

public class Main {

    static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // dp[i][j] = number of valid arrays till index i // such that arr[i] = j
        int[][] dp = new int[n][m + 2];

        // Base case
        if (arr[0] == 0) {
            for (int j = 1; j <= m; j++) {
                dp[0][j] = 1;
            }
        } else {
            dp[0][arr[0]] = 1;
        }

        // Fill DP table
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= m; j++) {

                // If current position is fixed to another value
                if (arr[i] != 0 && arr[i] != j) {
                    continue;
                }
                dp[i][j] = (int) (
                        ((long) dp[i - 1][j - 1] + dp[i - 1][j]  + dp[i - 1][j + 1]) % MOD );
            }
        }
        int ans = 0;

        for (int j = 1; j <= m; j++) {
            ans = (int) ((ans + (long) dp[n - 1][j]) % MOD);
        }
        System.out.println(ans);
    }
}