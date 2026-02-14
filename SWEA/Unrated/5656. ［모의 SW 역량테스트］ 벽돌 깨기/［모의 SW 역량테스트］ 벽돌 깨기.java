import java.util.*;
import java.io.*;

class Solution {
    private static int T, N, W, H, maxNum;
    private static BufferedReader br;
    private static int[][] map;
    private static int[] dy = {1, -1, 0, 0};    // 동 남 서 북
    private static int[] dx = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            initMap();
            maxNum = Integer.MIN_VALUE;
            recur(0, 0, map);
            int rst = count();

            sb.append("#").append(tc).append(" ").append(rst).append("\n");
        }

        System.out.println(sb.toString());
    }

    private static void recur(int cnt, int depth, int[][] map) {
        if(depth == N) {
            maxNum = Math.max(maxNum, cnt);
            return;
        }

        for (int i = 0; i < W; i++) {
            int[][] copyMap = copyMap(map);
            int bombCnt = bomb(copyMap, i);
            fall(copyMap);
            recur(cnt + bombCnt, depth + 1, copyMap);
        }
    }

    private static int bomb(int[][] copyMap, int col) {
        int row = 0;
        while (row < H && copyMap[row][col] == 0) {
            row++;
        }

        if(row == H) return 0;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{row, col});
        int cnt = 0;
        boolean[][] visited = new boolean[H][W];
        while(!q.isEmpty()) {
            int[] poll = q.poll();
            int cy = poll[0];
            int cx = poll[1];

            if(visited[cy][cx]) continue;
            visited[cy][cx] = true;
            cnt++;

            for (int dir = 0; dir < 4; dir++) {
                for (int power = 1; power < copyMap[cy][cx]; power++) {
                    int ny = cy + dy[dir] * power;
                    int nx = cx + dx[dir] * power;
                    if(isRange(ny, nx) && copyMap[ny][nx] != 0) {
                        q.add(new int[]{ny, nx});
                    }
                }
            }
        }

        for (int h = 0; h < H; h++) {
            for (int w = 0; w < W; w++) {
                if(visited[h][w]) copyMap[h][w] = 0;
            }
        }

        return cnt;
    }

    private static int[][] copyMap(int[][] origin) {
        int[][] copy = new int[H][W];

        for (int i = 0; i < H; i++) {
            copy[i] = Arrays.copyOf(origin[i], W);
        }
        return copy;
    }

    private static void fall(int[][] copy) {
        for (int col = 0; col < W; col++) {
            List<Integer> temp = new ArrayList<>();
            for (int row = H-1; row >= 0; row--) {
                if(copy[row][col] != 0) temp.add(copy[row][col]);
                copy[row][col] = 0;
            }
            for (int row = 0; row < temp.size(); row++) {
                copy[H - 1 - row][col] = temp.get(row);
            }
        }
    }
    
    private static int count() {
        int all = 0;
        for (int row = 0; row < H; row++) {
            for (int col = 0; col < W; col++) {
                if(map[row][col] != 0) all++;
            }
        }
        return all - maxNum;
    }

    private static void initMap() throws IOException {
        map = new int[H][W];

        StringTokenizer st;

        for (int row = 0; row < H; row++) {
            st = new StringTokenizer(br.readLine().trim());

            for (int col = 0; col < W; col++) {
                map[row][col] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static boolean isRange(int y, int x) {
        return y >= 0 && x >= 0 && y < H && x < W;
    }
}
