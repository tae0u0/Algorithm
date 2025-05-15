import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] W = new int[N];
        int[] V = new int[N];
        for(int i = 0; i<N; i++){
            W[i] = sc.nextInt();
            V[i] = sc.nextInt();
        }

        int[] dp = new int[K+1];

        for (int i = 0; i < N; i++) {
            for (int j = K; j >= W[i] ; j--) {
                dp[j] = Math.max(dp[j], dp[j - W[i]] + V[i]);
            }
        }

        System.out.println(dp[K]);
    }
}