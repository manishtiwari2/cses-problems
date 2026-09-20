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

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        int[] team = new int[n];
        boolean possible = true;

        for (int i = 0; i < n && possible; i++) {

            if (team[i] == 0) {
                team[i] = 1;

                Queue<Integer> queue = new ArrayDeque<>();
                queue.add(i);

                while (!queue.isEmpty() && possible) {
                    int curr = queue.poll();

                    for (int nei : graph.get(curr)) {

                        if (team[nei] == 0) {
                            team[nei] = 3 - team[curr];
                            queue.add(nei);
                        } 
                        else if (team[curr] == team[nei]) {
                            possible = false;
                            break;
                        }
                    }
                }
            }
        }

        if (!possible) {
            System.out.println("IMPOSSIBLE");
        } else {
            for (int i = 0; i < n; i++) {
                System.out.print(team[i] + " ");
            }
            System.out.println();
        }
    }
}