import java.util.*;
import java.io.*;

class Solution {
    private static int T, N, M, K;
    private static int[][] map, lifeMap;
    private static BufferedReader br;
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1, 1, 0, 0};
    private final static int SIZE = 400 ;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            initMap();
            proliferation();
            int rst = count();
            sb.append("#").append(tc).append(" ").append(rst).append("\n");
        }

        System.out.println(sb.toString());
    }

    private static void proliferation() {
        Queue<int[]> q = new LinkedList<>();
        for (int time = 1; time < K; time++) {
            for (int row = 0; row < SIZE; row++) {
                for (int col = 0; col < SIZE; col++) {
                    if(map[row][col] == time) {
                        for (int dir = 0; dir < 4; dir++) {
                            int ny = row + dy[dir];
                            int nx = col + dx[dir];
                            if(isRange(ny, nx) && map[ny][nx] == 0) {
                                lifeMap[ny][nx] = Math.max(lifeMap[ny][nx], lifeMap[row][col]);
                                q.add(new int[]{ny, nx, time + lifeMap[ny][nx] + 1});
                            }
                        }
                    }
                }
            }

            while(!q.isEmpty()){
                int[] ceil = q.poll();
                int y = ceil[0];
                int x = ceil[1];
                int life = ceil[2];
                map[y][x] = Math.max(map[y][x], life);
            }
        }
    }

    private static int count() {
        int cnt = 0;
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if(map[row][col] == 0) continue;
                if(map[row][col] + lifeMap[row][col] - 1 >= K) cnt++;
            }
        }
        return cnt;
    }

    private static void initMap() throws IOException {
        map = new int[SIZE][SIZE];
        lifeMap = new int[SIZE][SIZE];

        StringTokenizer st;

        for (int row = SIZE / 2; row < SIZE / 2 + N; row++) {
            st = new StringTokenizer(br.readLine().trim());

            for (int col = SIZE / 2; col < SIZE / 2 + M; col++) {
                int num = Integer.parseInt(st.nextToken());
                map[row][col] = num;
                lifeMap[row][col] = num;
            }
        }
    }

    private static boolean isRange(int y, int x) {
        return y >= 0 && x >= 0 && y < SIZE && x < SIZE;
    }
}