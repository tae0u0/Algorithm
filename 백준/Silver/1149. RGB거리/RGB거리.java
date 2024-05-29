import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine().trim());
        int[][] colorPrice = new int[num + 1][3];
        for (int i = 1; i <= num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            colorPrice[i][0] = Integer.parseInt(st.nextToken());
            colorPrice[i][1] = Integer.parseInt(st.nextToken());
            colorPrice[i][2] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[num+1][3];
        int rst = Integer.MAX_VALUE;

        for(int i=0; i<3; i++){
            for(int k=0; k<3; k++){
                if(i==k)
                    dp[1][i] = colorPrice[1][i];
                else
                    dp[1][k] = 100000;
            }
            for(int k=2; k<=num; k++){
                dp[k][0] = Math.min(dp[k-1][1], dp[k-1][2]) + colorPrice[k][0];
                dp[k][1] = Math.min(dp[k-1][0], dp[k-1][2]) + colorPrice[k][1];
                dp[k][2] = Math.min(dp[k-1][0], dp[k-1][1]) + colorPrice[k][2];
            }

            for(int k = 0; k<3; k++){
                rst = Math.min(dp[num][k], rst);
            }
        }

        bw.write(rst + "");
        bw.flush();
        bw.close();
    }

}
