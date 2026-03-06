import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] dist;
    static int[][] dp;
    static final int INF = 16_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dist = new int[N][N];
        dp = new int[1 << N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                dist[i][j] = Integer.parseInt(st.nextToken());
            }
            Arrays.fill(dp[1 << i], -1);
        }

        for(int i=0; i < (1 << N); i++) Arrays.fill(dp[i], -1);

        System.out.println(tsp(1, 0));
    }

    private static int tsp(int visit, int now) {
        if (visit == (1 << N) - 1) {
            if (dist[now][0] == 0) return INF;
            return dist[now][0];
        }

        if (dp[visit][now] != -1) return dp[visit][now];

        dp[visit][now] = INF;
        for (int i = 0; i < N; i++) {
            if ((visit & (1 << i)) == 0 && dist[now][i] != 0) {
                dp[visit][now] = Math.min(dp[visit][now], tsp(visit | (1 << i), i) + dist[now][i]);
            }
        }

        return dp[visit][now];
    }
}