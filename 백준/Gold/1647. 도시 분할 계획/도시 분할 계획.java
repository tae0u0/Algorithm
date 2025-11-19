import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static List<Node>[] adjacent;
    static boolean[] visited;
    static int maxCost = Integer.MIN_VALUE;
    static class Node implements Comparable<Node> {
        int to, cost;

        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N+1];

        adjacent = new ArrayList[N+1];
        for(int i = 0; i<= N; i++) {
            adjacent[i] = new ArrayList<>();
        }

        for(int i = 0; i<M; i++){
            String[] str = br.readLine().split(" ");
            int first = Integer.parseInt(str[0]);
            int second = Integer.parseInt(str[1]);
            int cost = Integer.parseInt(str[2]);
            adjacent[first].add(new Node(second, cost));
            adjacent[second].add(new Node(first, cost));
        }

        Queue<Node> q = new PriorityQueue<>();
        q.add(new Node(1, 0));

        int rst = 0;
        while(!q.isEmpty()) {
            Node poll = q.poll();
            if(visited[poll.to]) continue;

            visited[poll.to] = true;
            rst += poll.cost;
            maxCost = Math.max(maxCost, poll.cost);
            for(Node next : adjacent[poll.to]) {
                if(!visited[next.to]) {
                    q.add(next);
                }
            }
        }

        System.out.println(rst - maxCost);
    }
}