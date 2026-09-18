import java.io.*;
import java.util.*;

public class Main {
    static long total;
    static long ans = Long.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
            total += arr[i];
        }

        solve(arr,0,0);

        System.out.println(ans);
    }
    private static void solve(long[] arr, int idx, long G1) {

        if(idx == arr.length) {
            long diff = Math.abs(total - 2*G1);
            ans = Math.min(ans,diff);
            return;
        }
        solve(arr, idx+1, G1 + arr[idx]);
        solve(arr, idx+1, G1);

    }
}
