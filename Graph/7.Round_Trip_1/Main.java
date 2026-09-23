import java.io.*;
import java.util.*;

public class Main {

    static int start = -1;
    static int end = -1;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        boolean[] visited = new boolean[n];
        int[] parent = new int[n];

        for (int i = 0; i < n; i++) {

            if (!visited[i]) {

                if (dfs(i, graph, parent, visited)) {
                    break;
                }
            }
        }

        if (start == -1) {
            System.out.println("IMPOSSIBLE");
            return;
        }

        List<Integer> cycle = new ArrayList<>();

        cycle.add(start);
        int curr = end;

        while (curr != start) {
            cycle.add(curr);
            curr = parent[curr];
        }

        cycle.add(start);

        Collections.reverse(cycle);
        System.out.println(cycle.size());

        for (int node : cycle) {
            System.out.print((node + 1) + " ");
        }
        System.out.println();
    }

    private static boolean dfs(int node, List<List<Integer>> graph, int[] parent,boolean[] visited) {

        visited[node] = true;
        for (int v : graph.get(node)) {

            if (!visited[v]) {
                parent[v] = node;
                if (dfs(v, graph, parent, visited)) {
                    return true;
                }
            } else if (v != parent[node]) {

                start = v;
                end = node;
                return true;
            }
        }
        return false;
    }
}