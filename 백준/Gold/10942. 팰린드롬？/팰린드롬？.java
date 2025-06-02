import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] numbers;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        numbers = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        dp = new int[N+1][N+1];

        for (int i = 1; i <= N; i++) {
            Arrays.fill(dp[i], -1);
            dp[i][i] = 1;
        }

        while(M-- > 0){
            String[] split = br.readLine().split(" ");
            int start = Integer.parseInt(split[0]);
            int end = Integer.parseInt(split[1]);
            bw.write(dp(start, end)+ "\n");
        }
        bw.flush();
        bw.close();

    }

    private static int dp(int start, int end) {
        if(dp[start][end] != -1)
            return dp[start][end];

        if(end - start == 1){
            if(numbers[start] == numbers[end])
                return dp[start][end] = 1;
            else
                return dp[start][end] = 0;
        }

        if(dp(start + 1, end - 1) == 1 && numbers[start] == numbers[end]) dp[start][end] = 1;
        else dp[start][end] = 0;
        return dp[start][end];
    }
}
