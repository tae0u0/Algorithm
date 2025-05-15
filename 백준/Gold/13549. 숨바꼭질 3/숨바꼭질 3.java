import java.util.*;

public class Main {
    static final int MAX = (int)1e6 + 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] dist = new int[MAX];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[N] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(N, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int idx = cur.index;
            int time = cur.dist;

            if (dist[idx] < time) continue;

            if (idx * 2 < MAX && dist[idx * 2] > time) {
                dist[idx * 2] = time;
                pq.offer(new Node(idx * 2, time));
            }

            if (idx - 1 >= 0 && dist[idx - 1] > time + 1) {
                dist[idx - 1] = time + 1;
                pq.offer(new Node(idx - 1, time + 1));
            }

            if (idx + 1 < MAX && dist[idx + 1] > time + 1) {
                dist[idx + 1] = time + 1;
                pq.offer(new Node(idx + 1, time + 1));
            }
        }

        System.out.println(dist[K]);
    }

    static class Node implements Comparable<Node> {
        int index, dist;

        public Node(int index, int dist) {
            this.index = index;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.dist, o.dist);
        }
    }
}
