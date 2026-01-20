import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] adjacent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        adjacent = new int[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                adjacent[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(adjacent[i][k] == 1 && adjacent[k][j] == 1) adjacent[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(adjacent[i][j] > 0) bw.write("1 ");
                else bw.write("0 ");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}