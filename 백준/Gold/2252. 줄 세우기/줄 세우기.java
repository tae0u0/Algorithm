import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] degree;
    static List<Integer>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        degree = new int[N+1];
        graph = new ArrayList[N+1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            String[] split = br.readLine().split(" ");
            int prev = Integer.parseInt(split[0]);
            int next = Integer.parseInt(split[1]);
            graph[prev].add(next);
            degree[next]++;
        }

        Queue<Integer> q = new LinkedList();

        for (int i = 1; i <= N; i++) {
            if(degree[i] == 0) q.add(i);
        }

        while(!q.isEmpty()) {
            int poll = q.poll();
            bw.write(poll + " ");
            for(int nx : graph[poll]) {
                degree[nx]--;
                if(degree[nx] == 0) q.add(nx);
            }
        }

        bw.flush();
        bw.close();
    }
}
