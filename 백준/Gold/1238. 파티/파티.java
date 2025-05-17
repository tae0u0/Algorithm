import java.io.*;
import java.util.*;

public class Main {
    static int N, M, X;
    static ArrayList<ArrayList<Node>> adjacent = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken())-1;

        for (int i = 0; i < N; i++) {
            adjacent.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) -1;
            int to = Integer.parseInt(st.nextToken()) -1;
            int time = Integer.parseInt(st.nextToken());
            adjacent.get(from).add(new Node(to, time));
        }

        int max = 0;

        for (int i = 0; i < N; i++) {
            if(i == X)
                continue;

            int roundTime = getTime(i, X) + getTime(X, i);
            max = Math.max(max, roundTime);
        }

        System.out.println(max);
    }

    private static int getTime(int origin, int dest) {
        int[] times = new int[N];
        Arrays.fill(times, Integer.MAX_VALUE);
        times[origin] = 0;

        Queue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(origin, 0));

        while(!pq.isEmpty()){
            Node cur = pq.poll();

            for (Node next : adjacent.get(cur.to)) {
                int newTime = cur.time + next.time;
                if(times[next.to] > newTime){
                    times[next.to] = newTime;
                    pq.add(new Node(next.to, newTime));
                }
            }
        }

        return times[dest];
    }

    private static class Node implements Comparable<Node>{
        int to, time;

        public Node(int to, int time) {
            this.to = to;
            this.time = time;
        }

        @Override
        public int compareTo(Node o){
            return Integer.compare(this.time, o.time);
        }
    }
}