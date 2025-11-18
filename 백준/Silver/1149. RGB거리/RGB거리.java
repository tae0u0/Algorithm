import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] cost;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cost = new int[N][3];
        dp = new int[N][3];
        for(int i = 0; i < N; i++) {
            cost[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        dp[0][0] = cost[0][0];
        dp[0][1] = cost[0][1];
        dp[0][2] = cost[0][2];

        solve();
        int minNum = Integer.MAX_VALUE;
        for(int i = 0; i < 3; i++) {
            if(minNum > dp[N-1][i]) {
                minNum = dp[N-1][i];
            }
        }
        System.out.println(minNum);
    }

    private static void solve() {
        for(int i = 1; i < N; i++) {
            for(int j = 0; j < 3; j++) {
                int first = cost[i][j] + dp[i-1][(j+1) % 3];
                int second = cost[i][j] + dp[i-1][(j+2) % 3];
                dp[i][j] = Math.min(first, second);
            }
        }
    }
}