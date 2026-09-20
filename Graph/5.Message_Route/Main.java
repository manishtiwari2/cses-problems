import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

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

        int[] parent = new int[n];
        Arrays.fill(parent, -1);

        boolean[] visited = new boolean[n];

        Queue<Integer> queue = new ArrayDeque<>();

        queue.offer(0);
        visited[0] = true;

        while (!queue.isEmpty()) {

            int curr = queue.poll();

            for (int next : graph.get(curr)) {

                if (!visited[next]) {
                    visited[next] = true;
                    parent[next] = curr;
                    queue.offer(next);
                }
            }
        }

        if (!visited[n - 1]) {
            System.out.println("IMPOSSIBLE");
            return;
        }

        List<Integer> path = new ArrayList<>();

        int curr = n - 1;

        while (curr != -1) {
            path.add(curr);
            curr = parent[curr];
        }

        Collections.reverse(path);

        System.out.println(path.size());

        for (int node : path) {
            System.out.print((node + 1) + " ");
        }

        System.out.println();
    }
}