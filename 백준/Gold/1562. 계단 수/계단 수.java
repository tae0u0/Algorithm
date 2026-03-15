import java.io.*;
import java.util.*;

public class Main {

    static final int MOD = 1_000_000_000;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[][][] dp = new long[N+1][10][1<<10];

        for(int i=1;i<=9;i++){
            dp[1][i][1<<i] = 1;
        }

        for(int i=1;i<N;i++){
            for(int j=0;j<=9;j++){
                for(int mask=0;mask<(1<<10);mask++){

                    long cur = dp[i][j][mask];
                    if(cur==0) continue;

                    if(j>0){
                        int next=j-1;
                        int nMask = mask | (1<<next);
                        dp[i+1][next][nMask] = (dp[i+1][next][nMask] + cur) % MOD;
                    }

                    if(j<9){
                        int next=j+1;
                        int nMask = mask | (1<<next);
                        dp[i+1][next][nMask] = (dp[i+1][next][nMask] + cur) % MOD;
                    }

                }
            }
        }

        long ans=0;

        for(int i=0;i<=9;i++){
            ans = (ans + dp[N][i][(1<<10)-1]) % MOD;
        }

        System.out.println(ans);
    }
}