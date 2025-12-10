import java.io.*;
import java.util.*;

public class Main {
    static int R, C, rst = 0;
    static char[][] board;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Set<Character> alpha = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new char[R][C];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = str.charAt(j);
            }
        }

        backTracking(0, 0);
        System.out.println(rst);
    }

    private static void backTracking(int row, int col) {
        alpha.add(board[row][col]);
        rst = Math.max(rst, alpha.size());

        for (int i = 0; i < 4; i++) {
            int ny = row + dy[i];
            int nx = col + dx[i];
            if(isRange(ny, nx) && !alpha.contains(board[ny][nx])) {
                backTracking(ny, nx);
            }
        }
        alpha.remove(board[row][col]);
    }

    private static boolean isRange(int row, int col) {
        return row >= 0 && col >= 0 && row < R && col < C;
    }
}

