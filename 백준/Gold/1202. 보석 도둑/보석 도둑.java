import java.io.*;
import java.util.*;

public class Main {
    static class Jewelry {
        int weight, cost;
        public Jewelry(int weight, int cost) {
            this.weight = weight;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Jewelry[] jewelries = new Jewelry[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            jewelries[i] = new Jewelry(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(jewelries, (a, b) -> a.weight - b.weight);

        int[] bags = new int[K];
        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(bags);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        long totalSum = 0;
        int jewelryIndex = 0;

        for (int i = 0; i < K; i++) {
            while (jewelryIndex < N && jewelries[jewelryIndex].weight <= bags[i]) {
                pq.add(jewelries[jewelryIndex].cost);
                jewelryIndex++;
            }

            if (!pq.isEmpty()) {
                totalSum += pq.poll();
            }
        }

        System.out.println(totalSum);
    }
}