import java.util.*;
import java.io.*;

class Solution {
    private static int T, N, cy, cx, dir, cnt;
    private static BufferedReader br;
    private static int[][] map;
    private static int[] dy = {0, 1, 0, -1};    // 동 남 서 북
    private static int[] dx = {1, 0, -1, 0};
    private static Map<Integer, List<int[]>> wormhole;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine().trim());
            initMap();

            int rst = 0;

            for (int row = 0; row < N; row++) {
                for (int col = 0; col < N; col++) {

                    if (map[row][col] != 0) continue;

                    for (int direction = 0; direction < 4; direction++) {

                        cy = row;
                        cx = col;
                        dir = direction;
                        cnt = 0;

                        while (true) {
                            getNextPos();

                            if (isRange(cy, cx) && ((cy == row && cx == col) || map[cy][cx] == -1))
                                break;
                        }

                        rst = Math.max(rst, cnt);
                    }
                }
            }

            sb.append("#").append(tc).append(" ").append(rst).append("\n");
        }

        System.out.println(sb.toString());
    }

    private static void initMap() throws IOException {
        map = new int[N][N];
        wormhole = new HashMap<>();

        StringTokenizer st;

        for (int row = 0; row < N; row++) {
            st = new StringTokenizer(br.readLine().trim());

            for (int col = 0; col < N; col++) {
                int num = Integer.parseInt(st.nextToken());

                if (num >= 6 && num <= 10) {
                    wormhole.computeIfAbsent(num, k -> new ArrayList<>())
                            .add(new int[]{row, col});
                }

                map[row][col] = num;
            }
        }
    }

    private static void getNextPos() {

        cy += dy[dir];
        cx += dx[dir];

        if (!isRange(cy, cx)) {
            dir = (dir + 2) % 4;
            cnt++;
            return;
        }

        int cell = map[cy][cx];

        if (cell == 0) return;

        if (cell >= 1 && cell <= 5) {

            int nextDir = dir;

            switch (cell) {
                case 1:
                    if (dir == 1) nextDir = 0;
                    else if (dir == 2) nextDir = 3;
                    else nextDir = (dir + 2) % 4;
                    break;

                case 2:
                    if (dir == 2) nextDir = 1;
                    else if (dir == 3) nextDir = 0;
                    else nextDir = (dir + 2) % 4;
                    break;

                case 3:
                    if (dir == 0) nextDir = 1;
                    else if (dir == 3) nextDir = 2;
                    else nextDir = (dir + 2) % 4;
                    break;

                case 4:
                    if (dir == 0) nextDir = 3;
                    else if (dir == 1) nextDir = 2;
                    else nextDir = (dir + 2) % 4;
                    break;

                case 5:
                    nextDir = (dir + 2) % 4;
                    break;
            }

            dir = nextDir;
            cnt++;
            return;
        }

        if (cell >= 6 && cell <= 10) {

            List<int[]> list = wormhole.get(cell);

            int y1 = list.get(0)[0];
            int x1 = list.get(0)[1];
            int y2 = list.get(1)[0];
            int x2 = list.get(1)[1];

            if (cy == y1 && cx == x1) {
                cy = y2;
                cx = x2;
            } else {
                cy = y1;
                cx = x1;
            }
        }
    }

    private static boolean isRange(int y, int x) {
        return y >= 0 && x >= 0 && y < N && x < N;
    }
}
