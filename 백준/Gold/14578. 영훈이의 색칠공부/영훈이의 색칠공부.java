import java.io.*;

public class Main {
    static int[] dp;
    static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 0;

        int rst = (int)((Fact(n) * (long)Solution(n)) % MOD);  // Fact(n) * Solution(n)의 결과도 long으로 처리 후 MOD 적용

        bw.write(String.valueOf(rst));
        bw.flush();
        bw.close();
    }

    static int Fact(int n) {
        int rst = 1;
        for (int i = 2; i <= n; i++) {
            rst = (int)((rst * (long)i) % MOD);  // 모듈러 연산 적용
        }
        return rst;
    }

    static int Solution(int num) {
        if (num == 0) {
            return dp[0];
        }

        if (num == 1) {
            return dp[1];
        }

        for (int i = 2; i <= num; i++) {
            dp[i] = (int)(((long)(i - 1) * (dp[i - 1] + dp[i - 2])) % MOD);  // 각 연산에 모듈러 적용
        }
        return dp[num];
    }
}
