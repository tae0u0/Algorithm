import java.io.*;
import java.util.*;

public class Main {
    static int N, D;
    static Node[] arr;

    static class Node implements Comparable<Node> {
        int house, office;

        public Node(int house, int office) {
            this.house = house;
            this.office = office;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.office, o.office);
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        Arrays.sort(arr);
        Queue<Integer> pq = new PriorityQueue<>();
        int maxNum = 0;
        for (int i = 0; i < N; i++) {
            int end = arr[i].office;
            int start = end - D;
            if(arr[i].house < start) continue;

            pq.add(arr[i].house);
            while(!pq.isEmpty() && pq.peek() < start) {
                pq.poll();
            }

            maxNum = Math.max(maxNum, pq.size());
        }
        System.out.println(maxNum);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new Node[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int house = Integer.parseInt(st.nextToken());
            int office = Integer.parseInt(st.nextToken());
            if(house > office) arr[i] = new Node(office, house);
            else arr[i] = new Node(house, office);
        }
        D = Integer.parseInt(br.readLine());
    }
}