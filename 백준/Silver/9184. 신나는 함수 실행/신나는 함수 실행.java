import java.io.*;

public class Main {
    static int a, b, c;
    static int[][][] dp = new int[21][21][21];
    static int Solution(String[] num) {
        return Recur(a, b, c);
    }

    static int Recur(int a, int b, int c){
        if(a <= 0 || b <= 0 || c <= 0)
            return 1;

        if (a > 20 || b > 20 || c > 20) {
            if(dp[20][20][20] != -1)
                return dp[20][20][20];
            else
                return Recur(20, 20, 20);
        }

        if(dp[a][b][c] != -1)
            return dp[a][b][c];
        else if(a < b && b < c){
            dp[a][b][c] = Recur(a, b, c-1) + Recur(a, b-1, c-1) - Recur(a, b-1, c);
        }
        else {
            dp[a][b][c] = Recur(a-1, b, c) + Recur(a-1, b-1, c) + Recur(a-1, b, c-1) - Recur(a-1, b-1, c-1);
        }

        return dp[a][b][c];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i = 0; i<21; i++)
            for(int k = 0; k<21; k++)
                for(int j = 0; j<21; j++)
                    dp[i][k][j] = -1;

        String line;
        while((line = br.readLine()) != null && !line.isEmpty()){
            String[] num = line.split(" ");
            a = Integer.parseInt(num[0]);
            b = Integer.parseInt(num[1]);
            c = Integer.parseInt(num[2]);
            if(a == -1 && b==-1 && c==-1)
                break;
            int rst = Solution(num);
            bw.write("w(" + a + ", " + b + ", " + c +") = " + rst + "\n");
        }
        bw.flush();
        bw.close();
    }
}
