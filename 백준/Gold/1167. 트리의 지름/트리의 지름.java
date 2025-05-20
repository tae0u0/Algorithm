import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    static int V;
    static ArrayList<ArrayList<Edge>> edges = new ArrayList<>();
    static int[] distance;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());
        for (int i = 0; i <=V; i++) {
            edges.add(new ArrayList<>());
        }
        distance = new int[V + 1];

        for (int i = 0; i < V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            while(true){
                int to = Integer.parseInt(st.nextToken());
                if(to == -1)
                    break;

                int dist = Integer.parseInt(st.nextToken());
                edges.get(from).add(new Edge(to, dist));
            }
        }

        int furthest = bfs(1);
        int max_index = bfs(furthest);
        System.out.println(distance[max_index]);
    }

    private static int bfs(int start) {
        Queue<Edge> q = new LinkedList<>();
        q.add(new Edge(start, 0));
        boolean[] visited = new boolean[V + 1];
        distance = new int[V + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        
        while(!q.isEmpty()){
            Edge cur = q.poll();
            distance[cur.to] = Math.min(distance[cur.to], cur.dist);
            visited[cur.to] = true;

            for (Edge next : edges.get(cur.to)) {
                distance[next.to] = Math.min(distance[next.to], cur.dist + next.dist);
                if(!visited[next.to]){
                    q.add(new Edge(next.to, cur.dist + next.dist));
                }
            }
        }

        return IntStream.range(1, distance.length)
                .reduce((i, j) -> distance[i] >= distance[j] ? i : j)
                .getAsInt();
    }

    private static class Edge {
        int to, dist;

        public Edge(int to, int dist) {
            this.to = to;
            this.dist = dist;
        }
    }
}