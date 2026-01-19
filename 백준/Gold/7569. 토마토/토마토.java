import java.io.*;
import java.util.*;

public class Main {
    static int M, N, H;
    static int[][][] box;
    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        box = new int[H][N][M];
        Queue<int[]> q = new ArrayDeque<>();

        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                for (int m = 0; m < M; m++) {
                    box[h][n][m] = Integer.parseInt(st.nextToken());
                    if (box[h][n][m] == 1) {
                        q.offer(new int[]{h, n, m});
                    }
                }
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int z = cur[0], y = cur[1], x = cur[2];

            for (int i = 0; i < 6; i++) {
                int nz = z + dz[i];
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (inRange(nz, ny, nx) && box[nz][ny][nx] == 0) {
                    box[nz][ny][nx] = box[z][y][x] + 1;
                    q.offer(new int[]{nz, ny, nx});
                }
            }
        }

        int ans = 0;
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    if (box[h][n][m] == 0) {
                        System.out.println(-1);
                        return;
                    }
                    ans = Math.max(ans, box[h][n][m]);
                }
            }
        }

        System.out.println(ans - 1);
    }

    static boolean inRange(int h, int y, int x) {
        return h >= 0 && y >= 0 && x >= 0 && h < H && y < N && x < M;
    }
}