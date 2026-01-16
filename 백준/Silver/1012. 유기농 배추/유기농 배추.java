import java.util.*;
import java.io.*;

public class Main {
    static int T, N, M, K;
    static int[][] board;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());

        for (int testCase = 0; testCase < T; testCase++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            board = new int[N][M];

            initBoard(br);
            int rst = bfs();
            bw.write(rst + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static void initBoard(BufferedReader br) throws IOException {
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            board[y][x] = 1;
        }
    }

    private static int bfs() {
        boolean[][] visited = new boolean[N][M];
        Queue<int[]> q = new LinkedList<>();
        int sum = 0;
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < M; col++) {
                if(board[row][col] == 1 && !visited[row][col]) {
                    q.add(new int[]{row, col});
                    sum++;
                    while(!q.isEmpty()) {
                        int[] poll = q.poll();
                        int curY = poll[0];
                        int curX = poll[1];
                        if(visited[curY][curX]) continue;
                        visited[curY][curX] = true;

                        for (int i = 0; i < 4; i++) {
                            int ny = curY + dy[i];
                            int nx = curX + dx[i];
                            if(isRange(ny, nx) && board[ny][nx] == 1 && !visited[ny][nx]) q.add(new int[]{ny, nx});
                        }
                    }
                }
            }
        }
        return sum;
    }

    private static boolean isRange(int y, int x) {
        return y >= 0 && x >= 0 && y < N && x < M;
    }
}