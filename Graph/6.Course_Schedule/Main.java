import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        int[] indegree = new int[n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            indegree[b]++; 

            graph.get(a).add(b);
        }
        int count = 0;
        ArrayDeque<Integer> q = new ArrayDeque<>();

        for(int i = 0; i < n; i++) {
            if(indegree[i] == 0) {
                q.offer(i);
            }
        }
        StringBuilder sb = new StringBuilder();

        while(!q.isEmpty()) {
            int node = q.poll();
            sb.append(node + 1).append(" ");
            count++;

            for(int v : graph.get(node)) {
                indegree[v]--;
                if(indegree[v] == 0) {
                    q.offer(v);
                }
            }
        }
        if(count != n) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(sb);
        }
    }    

}