
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] coins = new int[n];
        int total = 0;

        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(st.nextToken());
            total += coins[i];
        }
        boolean[] dp = new boolean[total+1];
        dp[0] = true;


        for(int coin : coins) {
            for(int sum = total; sum >= 0; sum--) {
                if(dp[sum]) {
                    dp[sum + coin] = true;
                }
            }
        }
        int count = 0;
        for(int s = 1; s<= total;s++) {
            if(dp[s]) {
                count++;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(count).append("\n");

        for (int sum = 1; sum <= total; sum++) {
            if (dp[sum]) {
                sb.append(sum).append(" ");
            }
        }

        System.out.println(sb);
    }
}
