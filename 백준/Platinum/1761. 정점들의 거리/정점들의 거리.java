import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static int N, M;
    private static List<Edge>[] adjacent;
    private static int[] depth;
    private static long[] dist;
    private static int[][] parent;
    private static int MAX_LOG;

    static class Edge {
        int to, cost;
        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        initGraph();
        bfs(1);
        fillParent();

        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int lca = findLCA(a, b);
            long result = dist[a] + dist[b] - 2 * dist[lca];
            sb.append(result).append("\n");
        }
        System.out.print(sb);
    }

    private static void bfs(int root) {
        Queue<Integer> q = new LinkedList<>();
        q.add(root);
        boolean[] visited = new boolean[N + 1];
        visited[root] = true;
        depth[root] = 0;
        dist[root] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (Edge next : adjacent[cur]) {
                if (!visited[next.to]) {
                    visited[next.to] = true;
                    parent[0][next.to] = cur;
                    depth[next.to] = depth[cur] + 1;
                    dist[next.to] = dist[cur] + next.cost;
                    q.add(next.to);
                }
            }
        }
    }

    private static void fillParent() {
        for (int k = 1; k < MAX_LOG; k++) {
            for (int v = 1; v <= N; v++) {
                parent[k][v] = parent[k - 1][parent[k - 1][v]];
            }
        }
    }

    private static int findLCA(int a, int b) {
        if (depth[a] > depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }

        for (int i = MAX_LOG - 1; i >= 0; i--) {
            if (depth[b] - depth[a] >= (1 << i)) {
                b = parent[i][b];
            }
        }

        if (a == b) return a;

        for (int i = MAX_LOG - 1; i >= 0; i--) {
            if (parent[i][a] != parent[i][b]) {
                a = parent[i][a];
                b = parent[i][b];
            }
        }
        return parent[0][a];
    }

    private static void initGraph() throws IOException {
        N = Integer.parseInt(br.readLine());
        adjacent = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) adjacent[i] = new ArrayList<>();

        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            adjacent[a].add(new Edge(b, cost));
            adjacent[b].add(new Edge(a, cost));
        }

        depth = new int[N + 1];
        dist = new long[N + 1];
        MAX_LOG = (int) (Math.log(N) / Math.log(2)) + 1;
        parent = new int[MAX_LOG][N + 1];
    }
}