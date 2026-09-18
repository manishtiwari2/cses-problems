import java.io.*;
import java.util.*;

public class Main {

    static int n, m;

    static int[][] dirs = {{0, 1},{1, 0},{0, -1},{-1, 0}};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        char[][] grid = new char[n][m];

        for (int i = 0; i < n; i++) {
            grid[i] = br.readLine().toCharArray();
        }
        int rooms = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '.') {
                    rooms++;
                    bfs(i, j, grid);
                }
            }
        }
        System.out.println(rooms);
    }

    static void bfs(int row, int col, char[][] grid) {

        Queue<int[]> queue = new ArrayDeque<>();

        queue.add(new int[]{row, col});
        grid[row][col] = '#';

        while (!queue.isEmpty()) {

            int[] current = queue.poll();

            int r = current[0];
            int c = current[1];

            for (int[] dir : dirs) {

                int new_r = r + dir[0];
                int new_c = c + dir[1];

                if (new_r >= 0 && new_r < n && new_c >= 0 && new_c < m && grid[new_r][new_c] == '.') {
                    grid[new_r][new_c] = '#';
                    queue.add(new int[]{new_r, new_c});
                }
            }
        }
    }
}