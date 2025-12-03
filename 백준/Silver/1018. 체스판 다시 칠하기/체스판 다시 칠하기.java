import java.io.*;
import java.util.*;

public class Main {

    static char[][] board;
    static int N, M;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        int answer = Integer.MAX_VALUE;

        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                answer = Math.min(answer, countRepaint(i, j));
            }
        }
        System.out.println(answer);
    }

    private static int countRepaint(int x, int y) {
        int cntW = 0;
        int cntB = 0;

        for (int i = x; i < x + 8; i++) {
            for (int j = y; j < y + 8; j++) {

                if ((i + j) % 2 == 0) {
                    if (board[i][j] != 'W') cntW++;
                    if (board[i][j] != 'B') cntB++;
                }
                else {
                    if (board[i][j] != 'B') cntW++;
                    if (board[i][j] != 'W') cntB++;
                }
            }
        }

        return Math.min(cntW, cntB);
    }
}
