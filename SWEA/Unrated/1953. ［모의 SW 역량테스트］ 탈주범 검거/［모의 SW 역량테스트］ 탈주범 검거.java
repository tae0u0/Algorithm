import java.util.*;
import java.io.*;

class Solution {
    private static int T, N, M, R, C, L;
    private static int[][] map;
    private static boolean[][] visited;
    private static BufferedReader br;
    private static int[] dx = {0, 0, -1, 1};    // 상하좌우
    private static int[] dy = {-1, 1, 0, 0};
    private static int[][][] pipe = {
            {{1, 2, 5, 6}, {1, 2, 4, 7}, {1, 3, 4, 5}, {1, 3, 6, 7}},// 1번 파이프
            {{1, 2, 5, 6}, {1, 2, 4, 7}, {}, {}},
            {{}, {}, {1, 3, 4, 5}, {1, 3, 6, 7}},
            {{1, 2, 5, 6}, {}, {}, {1, 3, 6, 7}},
            {{}, {1, 2, 4, 7}, {}, {1, 3, 6, 7}},
            {{}, {1, 2, 4, 7}, {1, 3, 4, 5}, {}},
            {{1, 2, 5, 6}, {}, {1, 3, 4, 5}, {}}
    };

    private static int[][] pathDir = {
            {0, 1, 2, 3},
            {0, 1},
            {2, 3},
            {0, 3},
            {1, 3},
            {1, 2},
            {0, 2}
    };

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            initMap();
            int rst = bfs();
            sb.append("#").append(tc).append(" ").append(rst).append("\n");
        }

        System.out.println(sb.toString());
    }

    private static int bfs() {
        int cnt = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{R, C, 1});
        while(!q.isEmpty()) {
            int[] poll = q.poll();
            int cy = poll[0];
            int cx = poll[1];
            int time = poll[2];
            if(visited[cy][cx] || time > L) continue;
            visited[cy][cx] = true;
            cnt++;
            int num = map[cy][cx] - 1;
            for(int dir : pathDir[num]) {
                int ny = cy + dy[dir];
                int nx = cx + dx[dir];
                if(isRange(ny, nx) && map[ny][nx] != 0 && check(ny, nx, dir, map[cy][cx])) {
                    q.add(new int[]{ny, nx, time + 1});
                }
            }
        }
        return cnt;
    }

    private static boolean check(int ny, int nx, int dir, int prevNum) {
        int nextNum = map[ny][nx];

        for(int avail : pipe[prevNum - 1][dir]) {
            if(avail == nextNum) return true;
        }
        return false;
    }


    private static void initMap() throws IOException {
        map = new int[N][M];
        visited = new boolean[N][M];

        StringTokenizer st;

        for (int row = 0; row < N; row++) {
            st = new StringTokenizer(br.readLine().trim());

            for (int col = 0; col < M; col++) {
                map[row][col] = Integer.parseInt(st.nextToken());;
            }
        }
    }

    private static boolean isRange(int y, int x) {
        return y >= 0 && x >= 0 && y < N && x < M;
    }
}