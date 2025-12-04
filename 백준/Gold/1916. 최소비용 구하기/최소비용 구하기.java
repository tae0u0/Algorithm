import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static ArrayList<Node>[] bus;
    static int[] costs;
    static class Node {
        int to, cost;

        public Node( int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        bus = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            bus[i] = new ArrayList<>();
        }
        costs = new int[N+1];
        Arrays.fill(costs, Integer.MAX_VALUE);

        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            bus[from].add(new Node(to, cost));
        }

        st = new StringTokenizer(br.readLine());
        int origin = Integer.parseInt(st.nextToken());
        int dest = Integer.parseInt(st.nextToken());
        costs[origin] = 0;
        Queue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        pq.addAll(bus[origin]);

        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            int curPos = cur.to;
            if(costs[curPos] <= cur.cost) continue;

            costs[curPos] = cur.cost;
            for (int i = 0; i < bus[curPos].size(); i++) {
                Node next = bus[curPos].get(i);
                int nextCost = cur.cost + next.cost;
                if(costs[next.to] > nextCost)
                    pq.add(new Node(next.to, nextCost));
            }
        }

        System.out.println(costs[dest]);
    }
}
