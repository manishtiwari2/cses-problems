import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int m;
    static int k;
    static int sr;
    static int sc;

    static char[][] grid;
    static int[][] dirs = {{0, 1},{0, -1},{1, 0},{-1, 0}};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        k = Integer.parseInt(br.readLine().trim());

        sr = Integer.parseInt(br.readLine().trim());
        sc = Integer.parseInt(br.readLine().trim());

        grid = new char[n][m];

        for (int i = 0; i < n; i++) {
            grid[i] = br.readLine().toCharArray();
        }

        boolean[][] visited = new boolean[n][m];
        int moves = 0;
        visited[sr][sc] = true;

        if(dfs(sr, sc, visited, moves)){
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }
    private static boolean dfs(int i, int j, boolean[][] visited, int moves) {

        for(int[] dir : dirs) {

            int nr = dir[0] + i;
            int nc = dir[1] + j;

            if(nr < 0 || nc < 0 || nr >= n || nc >= m){
                continue;
            }

            if(grid[nr][nc] == '*') {
                continue;
            }
            if(nr == sr && nc == sc) {
                if(moves + 1 >= k) {
                    return true;
                }
                continue;
            }
            if(visited[nr][nc]) {
                continue;
            }
            visited[nr][nc] = true;

            if(dfs(nr, nc, visited, moves + 1)) {
                return true;
            }
            visited[nr][nc] = false;
        }
        return false;
    }
}