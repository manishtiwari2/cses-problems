import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        int moves = (1 << n) - 1;
        System.out.println(moves);
        solve(n, 1, 3, 2);
        System.out.println(sb);
    }

    private static void solve(int n, int from, int to, int aux) {
        if (n == 1) {
            sb.append(from).append(" ").append(to).append("\n");
            return;
        }

        solve(n - 1, from, aux, to);
        sb.append(from).append(" ").append(to).append("\n");
        solve(n - 1, aux, to, from);
    }
}