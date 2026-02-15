import java.util.*;
import java.io.*;

class Solution {
    private static int T, N, K, maxNum;
    private static int[][] map;
    private static boolean[][] visited;
    private static BufferedReader br;
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            initMap();
            maxNum = Integer.MIN_VALUE;
            Queue<int[]> peakPos = getPeakPos();
            for (int[] peak : peakPos) {
                int peakY = peak[0];
                int peakX = peak[1];
                dfs(peakY, peakX, true, 1);
            }
            sb.append("#").append(tc).append(" ").append(maxNum).append("\n");
        }

        System.out.println(sb.toString());
    }

    private static void dfs(int row, int col, boolean canDig, int cnt) {
        visited[row][col] = true;
        boolean flag = false;
        for (int dir = 0; dir < 4; dir++) {
            int ny = row + dy[dir];
            int nx = col + dx[dir];
            if(isRange(ny, nx) && !visited[ny][nx]) {
                if(map[ny][nx] < map[row][col]) {
                    dfs(ny, nx, canDig, cnt + 1);
                    flag = true;
                } else if(canDig){
                    if(map[ny][nx] - map[row][col] < K) {
                        int temp = map[ny][nx];
                        map[ny][nx] = map[row][col] - 1;
                        dfs(ny, nx, false, cnt + 1);
                        flag = true;
                        map[ny][nx] = temp;
                    }
                }
            }
        }
        if(!flag) maxNum = Math.max(maxNum, cnt);
        visited[row][col] = false;
    }

    private static void initMap() throws IOException {
        map = new int[N][N];
        visited = new boolean[N][N];

        StringTokenizer st;

        for (int row = 0; row < N; row++) {
            st = new StringTokenizer(br.readLine().trim());

            for (int col = 0; col < N; col++) {
                map[row][col] = Integer.parseInt(st.nextToken());;
            }
        }
    }

    private static Queue<int[]> getPeakPos() {
        Queue<int[]> q = new LinkedList<>();
        int maxNum = Integer.MIN_VALUE;
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                maxNum = Math.max(maxNum, map[row][col]);
            }
        }

        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                if(map[row][col] == maxNum) q.add(new int[]{row, col});
            }
        }
        return q;
    }

    private static boolean isRange(int y, int x) {
        return y >= 0 && x >= 0 && y < N && x <  N;
    }
}