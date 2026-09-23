import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        // Build graph
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        boolean[] visited = new boolean[n];

        int components = 0;

        // Find connected components
        for (int i = 0; i < n; i++) {

            if (!visited[i]) {

                components++;

                Queue<Integer> queue = new ArrayDeque<>();
                queue.offer(i);
                visited[i] = true;

                while (!queue.isEmpty()) {

                    int curr = queue.poll();

                    for (int v : graph[curr]) {

                        if (!visited[v]) {
                            visited[v] = true;
                            queue.offer(v);
                        }
                    }
                }
            }
        }

        System.out.println(components - 1);
    }
}