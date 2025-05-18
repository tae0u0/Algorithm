import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int from, to, time;

        public Edge(int from, int to, int time) {
            this.from = from;
            this.to = to;
            this.time = time;
        }
    }

    static int TC, N, M, W;
    static List<Edge> graph;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TC = Integer.parseInt(br.readLine());

        while (TC-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            graph = new ArrayList<>();

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                graph.add(new Edge(s, e, t));
                graph.add(new Edge(e, s, t));
            }

            for (int i = 0; i < W; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                graph.add(new Edge(s, e, -t));
            }

            boolean hasCycle = false;

            for (int start = 1; start <= N; start++) {
                if (bellmanFord(start)) {
                    hasCycle = true;
                    break;
                }
            }

            System.out.println(hasCycle ? "YES" : "NO");
        }
    }

    static boolean bellmanFord(int start) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        for (int i = 1; i < N; i++) {
            boolean updated = false;
            for (Edge edge : graph) {
                if (dist[edge.from] != INF && dist[edge.to] > dist[edge.from] + edge.time) {
                    dist[edge.to] = dist[edge.from] + edge.time;
                    updated = true;
                }
            }
            if (!updated) break;
        }

        for (Edge edge : graph) {
            if (dist[edge.from] != INF && dist[edge.to] > dist[edge.from] + edge.time) {
                return true;
            }
        }

        return false;
    }
}
