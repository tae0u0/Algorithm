import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine().trim());

        int[] dp = new int[num + 2];
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3; i<=num; i++){
            dp[i] = (dp[i-1]+dp[i-2]) % 10007;
        }

        bw.write(dp[num]+"");
        bw.flush();
        bw.close();
    }
}