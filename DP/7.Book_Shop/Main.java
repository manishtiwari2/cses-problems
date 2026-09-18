import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int[] price = new int[n];
        int[] pages = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            pages[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solve(price, pages, x, 0));
    }
    static int solve(int[] price, int[] pages, int total, int idx) {
        if(idx >= pages.length) {
            return 0;
        }
        int take = 0;
        if(total >= price[idx]) {
            take = pages[idx] + solve(price, pages, total-price[idx], idx+1);
        }
        
        int not_take = solve(price, pages, total, idx+ 1);
        return Math.max(take, not_take);
    }
}