import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while(T-- > 0){
            int N = sc.nextInt();
            int[][] sticker = new int[N+1][3];
            int[][] dp = new int[N+1][3];

            for (int i = 1; i <= 2; i++) {
                for (int j = 1; j <= N; j++) {
                    sticker[j][i] = sc.nextInt();
                }
            }

            dp[1][1] = sticker[1][1];
            dp[1][2] = sticker[1][2];
            for (int i = 2; i <= N; i++) {
                dp[i][1] = Math.max(sticker[i][1] + dp[i - 1][2], sticker[i][1] + dp[i-2][2]);
                dp[i][2] = Math.max(sticker[i][2] + dp[i - 1][1], sticker[i][2] + dp[i-2][1]);
            }

            System.out.println(Math.max(dp[N][1], dp[N][2]));
        }
    }
}