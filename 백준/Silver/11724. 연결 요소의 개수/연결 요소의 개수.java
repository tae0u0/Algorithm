import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static List<Integer>[] adjacent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adjacent = new ArrayList[N+1];

        for (int i = 0; i <= N; i++) {
            adjacent[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adjacent[u].add(v);
            adjacent[v].add(u);
        }

        boolean[] visited = new boolean[N + 1];
        Queue<Integer> q = new LinkedList<>();
        int rst = 0;
        for (int i = 1; i <= N; i++) {
            if(adjacent[i].isEmpty()) {
                rst++;
                continue;
            }

            if(visited[i]) continue;

            q.add(i);
            while(!q.isEmpty()) {
                int cur = q.poll();
                if(visited[cur]) continue;
                visited[cur] = true;

                for(int num : adjacent[cur]) {
                    if(!visited[num]) {
                        q.add(num);
                    }
                }
            }

            rst++;
        }

        System.out.println(rst);
    }
}