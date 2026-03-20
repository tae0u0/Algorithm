import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] map;
    static boolean[][] visited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int cnt = 0;
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < M; col++) {
                if(visited[row][col]) continue;
                bfs(row, col);
                cnt++;
            }
        }
        System.out.print(cnt);
    }

    private static void bfs(int row, int col) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{row, col});
        visited[row][col] = true;
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int cy = cur[0];
            int cx = cur[1];

            for (int dir = 0; dir < 4; dir++) {
                int ny = cy + dy[dir];
                int nx = cx + dx[dir];
                if(isRange(ny, nx) && !visited[ny][nx] && check(ny, nx, dir)) {
                    visited[ny][nx] = true;
                    q.add(new int[]{ny, nx});
                }
            }
            
            int[] nextPos = getNextPos(cy, cx);
            int ny = nextPos[0];
            int nx = nextPos[1];
            if (!visited[ny][nx]) {
                visited[ny][nx] = true;
                q.add(new int[]{ny, nx});
            }
        }
    }

    private static int[] getNextPos(int cy, int cx) {
        if(map[cy][cx] == 'D') {
            return new int[]{cy + 1, cx};
        } else if(map[cy][cx] == 'U') {
            return new int[]{cy - 1, cx};
        } else if(map[cy][cx] == 'L') {
            return new int[]{cy, cx - 1};
        }
        return new int[]{cy, cx + 1};
    }

    private static boolean check(int ny, int nx, int dir) {
        if(dir == 0 && map[ny][nx] == 'D') return true;
        else if(dir == 1 && map[ny][nx] == 'U') return true;
        else if(dir == 2 && map[ny][nx] == 'R') return true;
        else if(dir == 3 && map[ny][nx] == 'L') return true;
        return false;
    }

    private static boolean isRange(int y, int x) {
        return y < N && x < M && y >= 0 && x >= 0;
    }
}