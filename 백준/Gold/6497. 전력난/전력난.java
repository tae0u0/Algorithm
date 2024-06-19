import java.util.*;

public class Main{
    static class Edge implements Comparable<Edge>{
        int end, cost;

        public Edge(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }
    static int house_num, load_num;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st;
        while(true)
        {
            st = new StringTokenizer(sc.nextLine());
            house_num = Integer.parseInt(st.nextToken());
            load_num = Integer.parseInt(st.nextToken());
            int total = 0;
            int rst = 0;

            if(house_num == 0 && load_num == 0)
                break;

            ArrayList<ArrayList<Edge>> adjacent = new ArrayList<>();
            for (int i = 0; i < house_num; i++)
                adjacent.add(new ArrayList<>());

            for (int i = 0; i < load_num; i++) {
                st = new StringTokenizer(sc.nextLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                adjacent.get(start).add(new Edge(end, cost));
                adjacent.get(end).add(new Edge(start, cost));
                total += cost;
            }

            PriorityQueue<Edge> pq = new PriorityQueue<>();
            pq.add(new Edge(0, 0));


            visited = new boolean[house_num];
            Arrays.fill(visited, false);

            while (!pq.isEmpty()) {
                Edge node = pq.poll();

                if (visited[node.end])
                    continue;

                visited[node.end] = true;
                rst += node.cost;

                for (int i = 0; i < adjacent.get(node.end).size(); i++) {
                    int dest = adjacent.get(node.end).get(i).end;
                    if (visited[dest] == false) {
                        pq.add(adjacent.get(node.end).get(i));
                    }
                }
            }
            System.out.println(total - rst);
        }
    }
}