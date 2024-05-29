import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine().trim());
        int[] point = new int[num + 1];

        for (int i = 1; i <= num; i++) {
            point[i] = Integer.parseInt(br.readLine().trim());
        }


        int[][] dp = new int[num + 1][2];
        dp[1][0] = point[1];
        dp[1][1] = point[1];

        for(int i=2; i<=num; i++){
            // 내 앞만 비어 있으면 뭘 하든 상관 없음
            dp[i][0] = Math.max(dp[i - 2][0], dp[i - 2][1]) + point[i];
            // 내 앞앞 만 비어 있으면 뭘 하든 상관 없음
            dp[i][1] = dp[i - 1][0] + point[i];
        }

        int max = Math.max(dp[num][0], dp[num][1]);

        bw.write(max + "");
        bw.flush();
        bw.close();
    }
}