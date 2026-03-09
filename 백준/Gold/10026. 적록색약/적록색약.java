import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N;
    private static char[][] map;
    private static int[] dy = {-1, 1, 0, 0};
    private static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        init();
        int cnt1 = bfs();
        int cnt2 = bfs2();
        System.out.println(cnt1 + " " + cnt2);
    }

    private static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        int cnt = 0;
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                if(visited[row][col]) continue;
                q.add(new int[]{row, col});
                while(!q.isEmpty()) {
                    int[] cur = q.poll();
                    int cy = cur[0];
                    int cx = cur[1];
                    if(visited[cy][cx]) continue;
                    visited[cy][cx] = true;

                    for (int dir = 0; dir < 4; dir++) {
                        int ny = cy + dy[dir];
                        int nx = cx + dx[dir];
                        if(isRange(ny, nx) && !visited[ny][nx] && map[row][col] == map[ny][nx]) {
                            q.add(new int[]{ny, nx});
                        }
                    }
                }
                cnt++;
            }
        }
        return cnt;
    }

    private static int bfs2() {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        int cnt = 0;
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                if(visited[row][col]) continue;
                q.add(new int[]{row, col});
                while(!q.isEmpty()) {
                    int[] cur = q.poll();
                    int cy = cur[0];
                    int cx = cur[1];
                    if(visited[cy][cx]) continue;
                    visited[cy][cx] = true;

                    for (int dir = 0; dir < 4; dir++) {
                        int ny = cy + dy[dir];
                        int nx = cx + dx[dir];
                        if(isRange(ny, nx) && !visited[ny][nx] && check(row, col, ny, nx)) {
                            q.add(new int[]{ny, nx});
                        }
                    }
                }
                cnt++;
            }
        }
        return cnt;
    }

    private static boolean check(int sy, int sx, int ny, int nx) {
        if(map[sy][sx] == 'B' && map[ny][nx] == 'B') return true;
        else if(map[sy][sx] != 'B' && map[ny][nx] != 'B') return true;
        return false;
    }

    private static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        for (int row = 0; row < N; row++) {
            map[row] = br.readLine().toCharArray();
        }
    }

    private static boolean isRange(int y, int x) {
        return y < N && x < N && y >= 0 && x >= 0;
    }
}