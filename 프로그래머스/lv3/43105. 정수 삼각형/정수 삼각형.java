class Solution {
    private int[][] dp;
    private int N, M;
    public int solution(int[][] triangle) {
        N = triangle.length;
        M = triangle[N-1].length;
        dp = new int[N][M];
        dp[0][0] = triangle[0][0];
        
        int answer = 0;
        for(int i = 1; i < N; i++) {
            for(int j = 0; j < triangle[i].length; j++) {
                if(j-1 >= 0) {
                    dp[i][j] = Math.max(dp[i-1][j-1] + triangle[i][j], dp[i][j]);
                }
                if(j <= triangle[i-1].length) {
                    dp[i][j] = Math.max(dp[i-1][j] + triangle[i][j], dp[i][j]);
                }
            }
        }
        for(int i = 0; i < M; i++) {
            answer = Math.max(answer, dp[N-1][i]);
        }
        return answer;
    }
}