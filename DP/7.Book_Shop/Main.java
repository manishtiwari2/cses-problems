import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        // BufferedReader for fast input
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        // Read n = number of books
        // Read x = maximum amount of money available
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        // price[i] = price of ith book
        int[] price = new int[n];

        // pages[i] = number of pages in ith book
        int[] pages = new int[n];

        // Read prices of all books
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }

        // Read pages of all books
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            pages[i] = Integer.parseInt(st.nextToken());
        }

        // dp[j] = maximum pages we can get
        // using at most j amount of money
        int[] dp = new int[x + 1];

        // Try every book
        for (int i = 0; i < n; i++) {
            // Go backwards to ensure each book is selected at most once
            for (int j = x; j >= price[i]; j--) {

                // Option 1: Don't take current book // dp[j]
                // Option 2: Take current book // dp[j - price[i]] + pages[i]
                dp[j] = Math.max(dp[j], dp[j - price[i]] + pages[i]);
            }
        }
        // Maximum pages possible with budget x
        System.out.println(dp[x]);
    }
}