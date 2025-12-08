import java.io.*;
import java.util.*;

public class Main {
    static int N, E;
    static int[][] dist;
    static final int INF = Integer.MAX_VALUE;

    static class Node implements Comparable<Node> {
        int to, cost;

        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        dist = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            dist[i][i] = 0;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            dist[first][second] = cost;
            dist[second][first] = cost;
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N ; i++) {
                for (int j = 1; j <= N; j++) {
                    if(dist[i][k] != INF && dist[k][j] != INF && dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int u = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        int rst = dist[u][v];
        rst += Math.min(dist[1][v] + dist[u][N], dist[1][u] + dist[v][N]);

        if(dist[1][u] == INF || dist[u][v] == INF || dist[v][N] == INF)
            System.out.println(-1);
        else
            System.out.println(rst);
    }
}