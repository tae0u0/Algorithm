import java.io.*;
import java.util.*;

public class Main {
    static int N, maxH, minH, rst = 1;
    static int[][] map;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        StringTokenizer st;

        minH = Integer.MAX_VALUE;
        maxH = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                minH = Math.min(minH, num);
                maxH = Math.max(maxH, num);
                map[i][j] = num;
            }
        }

        for (int i = minH; i <= maxH ; i++) {
            rst = Math.max(bfs(i), rst);
        }

        System.out.println(rst);

    }

    private static int bfs(int height) {
        boolean[][] safe = safetyArea(height);
        Queue<int[]> q = new LinkedList<>();
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!safe[i][j]) continue;
                q.add(new int[]{i, j});
                while(!q.isEmpty()){
                    int[] poll = q.poll();
                    int curY = poll[0];
                    int curX = poll[1];

                    if(!safe[curY][curX]) continue;
                    safe[curY][curX] = false;

                    for (int dir = 0; dir < 4; dir++) {
                        int ny = curY + dy[dir];
                        int nx = curX + dx[dir];
                        if(isRange(ny, nx) && safe[ny][nx]) {
                            q.add(new int[]{ny, nx});
                        };
                    }
                }
                cnt++;
            }
        }
        return cnt;
    }

    private static boolean[][] safetyArea(int height) {
        boolean[][] available = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] > height) {
                    available[i][j] = true;
                };
            }
        }

        return available;
    }

    private static boolean isRange(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < N;
    }

}
