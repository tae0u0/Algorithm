class Solution {
    int M, N;
    int[][] dp;
    boolean[][] puddle;
    int MOD =  1_000_000_007;
    public int solution(int m, int n, int[][] puddles) {
        M = m;
        N = n;
        puddle = new boolean[N+1][M+1];
        for(int i = 0; i<puddles.length; i++) {
            puddle[puddles[i][1]][puddles[i][0]] = true;
        }
        
        dp = new int[N+1][M+1];
        dp[1][1] = 1;
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++) {
                if(puddle[i][j] || (i == 1 && j == 1)) continue;
                dp[i][j] = (dp[i-1][j] % MOD + dp[i][j-1] % MOD) % MOD;
            }
        }
        
        return dp[N][M];
    }
}