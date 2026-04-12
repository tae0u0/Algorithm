import java.io.*;
import java.util.*;

public class Main {
    private static int N, M, K, X;
    private static List<Integer>[] edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        edges = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            edges[from].add(to);
        }

        int[] dist = dijkstra();
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for (int i = 1; i <= N; i++) {
            if(dist[i] == K) {
                flag = true;
                sb.append(i).append('\n');
            }
        }

        if(flag) System.out.println(sb.toString());
        else System.out.println(-1);

    }

    private static int[] dijkstra() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{X, 0});
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[X] = 0;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int city = cur[0];
            int d = cur[1];
            if(dist[city] != d) continue;

            for(int next : edges[city]) {
                if(dist[next] > d + 1) {
                    dist[next] = d + 1;
                    q.add(new int[]{next, d + 1});
                }
            }
        }

        return dist;
    }
}