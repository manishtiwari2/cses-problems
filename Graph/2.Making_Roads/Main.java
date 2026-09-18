import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<List<Integer>>  graph = new ArrayList<>();

        for(int i=0; i<n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int i=0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a-1).add(b-1);
            graph.get(b-1).add(a-1);
        }
        int ans = 0;
        List<Integer> cities = new ArrayList<>();
        boolean[] visited = new boolean[n];

        for(int i=0; i<n; i++){
            if(!visited[i]) {
                cities.add(i);
                dfs(i, graph, visited);
            }
        }

        System.out.println(cities.size()-1);

        for(int i = 1; i < cities.size(); i++) {
            System.out.println((cities.get(i - 1) + 1) + " " + (cities.get(i) + 1));
        }
    }
    private static void dfs(int i, List<List<Integer>> graph, boolean[] visited) {

        visited[i] = true;

        for(int neigh : graph.get(i)) {
            if(!visited[neigh]) {
                dfs(neigh, graph, visited);
            }
        }
    }
}
