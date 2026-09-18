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
        int[] team = new int[n];

        for(int i = 0; i < n; i++) {
            if(team[i] == 0) {
                team[i] = 1;

                Queue<Integer> queue = new ArrayDeque<>();
                queue.add(i);

                while(!queue.isEmpty()) {
                    int curr = queue.poll();

                    for(int nei : graph.get(curr)) {
                        if(team[nei] == 0) {
                            team[nei] = 2;
                            queue.add(nei);
                        } else {
                            if(team[curr] == team[nei]) {
                                System.out.println("IMPOSSIBLE");
                                break;
                            }
                        }
                    }
                }
            }
        }
        for(int i = 0; i<n; i++) {
            System.out.print(team[i] + " ");
        }
    }
}
