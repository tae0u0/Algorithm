import java.io.*;
import java.util.*;

public class Main {
    static int V, E;
    static int[][] dist;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        V = Integer.parseInt(br.readLine());
        E = Integer.parseInt(br.readLine());
        dist = new int[V + 1][V + 1];

        // 겁나 큰 수로 초기화
        for (int i = 0; i < V+1; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            dist[i][i] = 0;
        }

        for (int i = 0; i < E; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            dist[from][to] = Math.min(dist[from][to], value);
        }

        for (int k = 1; k <= V; k++) {
            for (int i = 1; i <= V; i++) {
                if (dist[i][k] == Integer.MAX_VALUE) continue;

                for (int j = 1; j <= V; j++) {
                    if (dist[k][j] == Integer.MAX_VALUE) continue;

                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V ; j++) {
                if(dist[i][j] == Integer.MAX_VALUE)
                    dist[i][j] = 0;
                bw.write(dist[i][j] + " ");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}