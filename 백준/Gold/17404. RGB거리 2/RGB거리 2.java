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

        int[][] dp = new int[num + 1][3];
        int rst = Integer.MAX_VALUE;;

        for(int i=0; i<3; i++){
            for(int k=0; k<3; k++){
                if(i == k)
                    dp[1][i] = colorPrice[1][i];
                else
                    dp[1][k] = 1000000;
            }

            for(int j = 2; j<=num; j++){
                dp[j][0] = Math.min(dp[j-1][1], dp[j-1][2]) + colorPrice[j][0];
                dp[j][1] = Math.min(dp[j-1][0], dp[j-1][2]) + colorPrice[j][1];
                dp[j][2] = Math.min(dp[j-1][0], dp[j-1][1]) + colorPrice[j][2];
            }

                for(int p =0; p<3; p++){
                    if(i!=p) rst = Math.min(dp[num][p], rst);
            }
        }

        bw.write(rst + "");
        bw.flush();
        bw.close();
    }

}
