import java.io.*;
import java.util.*;

public class Main {

    static int n, m;

    static int[][] dirs = {
        {1, 0},   // D
        {-1, 0},  // U
        {0, 1},   // R
        {0, -1}   // L
    };

    static char[] moves = {'D', 'U', 'R', 'L'};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
        );

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        char[][] grid = new char[n][m];

        int sr = -1, sc = -1;
        int er = -1, ec = -1;

        for (int i = 0; i < n; i++) {

            grid[i] = br.readLine().toCharArray();

            for (int j = 0; j < m; j++) {

                if (grid[i][j] == 'A') {
                    sr = i;
                    sc = j;
                }

                if (grid[i][j] == 'B') {
                    er = i;
                    ec = j;
                }
            }
        }

        // parentR[r][c] = previous row
        // parentC[r][c] = previous column
        int[][] parentR = new int[n][m];
        int[][] parentC = new int[n][m];

        // move[r][c] = move used to reach (r, c)
        char[][] move = new char[n][m];

        boolean[][] visited = new boolean[n][m];

        Queue<int[]> q = new ArrayDeque<>();

        q.offer(new int[]{sr, sc});
        visited[sr][sc] = true;

        while (!q.isEmpty()) {

            int[] cur = q.poll();

            int r = cur[0];
            int c = cur[1];

            if (r == er && c == ec) {
                break;
            }

            for (int d = 0; d < 4; d++) {

                int nr = r + dirs[d][0];
                int nc = c + dirs[d][1];

                // Out of bounds
                if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
                    continue;
                }

                // Wall
                if (grid[nr][nc] == '#') {
                    continue;
                }

                // Already visited
                if (visited[nr][nc]) {
                    continue;
                }

                visited[nr][nc] = true;

                // Remember parent
                parentR[nr][nc] = r;
                parentC[nr][nc] = c;

                // Remember move
                move[nr][nc] = moves[d];

                q.offer(new int[]{nr, nc});
            }
        }

        if (!visited[er][ec]) {
            System.out.println("NO");
            return;
        }

        // Reconstruct path
        StringBuilder path = new StringBuilder();

        int r = er;
        int c = ec;

        while (r != sr || c != sc) {

            path.append(move[r][c]);

            int pr = parentR[r][c];
            int pc = parentC[r][c];

            r = pr;
            c = pc;
        }

        path.reverse();

        System.out.println("YES");
        System.out.println(path.length());
        System.out.println(path);
    }
}