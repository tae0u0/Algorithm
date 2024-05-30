import java.io.*;
import java.util.*;

public class Main {
    static List<Node>[] adjacent = new ArrayList[10000];
    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < 10000; i++) {
            adjacent[i] = new ArrayList<>();
        }

        int num = Integer.parseInt(br.readLine().trim());
        int[][] info = new int[num][3];

        for (int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            info[i][0] = Integer.parseInt(st.nextToken());
            info[i][1] = Integer.parseInt(st.nextToken());
            info[i][2] = Integer.parseInt(st.nextToken()) - 1;

            int computerNum = info[i][0];

            for (int k = 0; k < info[i][1]; k++) {
                StringTokenizer edgeToken = new StringTokenizer(br.readLine());
                int to = Integer.parseInt(edgeToken.nextToken()) - 1;
                int from = Integer.parseInt(edgeToken.nextToken()) - 1;
                int cost = Integer.parseInt(edgeToken.nextToken());
                adjacent[from].add(new Node(to, cost));
            }

            distance = new int[computerNum];
            Arrays.fill(distance, Integer.MAX_VALUE);

            Dijkstra(info[i][2]);

            int infectionNum = 0;
            int spendTime = 0;

            for (int k = 0; k < computerNum; k++) {
                if (distance[k] != Integer.MAX_VALUE) {
                    infectionNum++;
                    spendTime = Math.max(spendTime, distance[k]);
                }
            }

            bw.write(infectionNum + " " + spendTime + "\n");
            bw.flush();

            for (int k = 0; k < computerNum; k++) {
                adjacent[k].clear();
            }
        }

        bw.close();
    }

    static void Dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        distance[start] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int from = node.to;
            int cost = node.cost;

            if (cost > distance[from]) continue;

            for (Node neighbor : adjacent[from]) {
                int newCost = cost + neighbor.cost;
                if (newCost < distance[neighbor.to]) {
                    distance[neighbor.to] = newCost;
                    pq.add(new Node(neighbor.to, newCost));
                }
            }
        }
    }
}

class Node implements Comparable<Node> {
    int to;
    int cost;

    public Node(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(this.cost, o.cost);
    }
}
