import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int max = 0;

    static int[][] direction = {
            {-1, 0}, {0, 1}, {1, 0}, {0, -1}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(i, j, 1, map[i][j]);
                visited[i][j] = false;
                checkExtraShape(i, j);
            }
        }

        System.out.println(max);
    }

    static void dfs(int y, int x, int depth, int sum) {
        if (depth == 4) {
            max = Math.max(max, sum);
            return;
        }

        for (int dir = 0; dir < 4; dir++) {
            int next_y = y + direction[dir][0];
            int next_x = x + direction[dir][1];

            if (next_x >= 0 && next_y >= 0 && next_x < M && next_y < N && !visited[next_y][next_x]) {
                visited[next_y][next_x] = true;
                dfs(next_y, next_x, depth + 1, sum + map[next_y][next_x]);
                visited[next_y][next_x] = false; // 복구
            }
        }
    }

    static void checkExtraShape(int y, int x) {
        if (y-1 >= 0 && x-1 >= 0 && x+1 < M) {
            int temp = map[y][x] + map[y-1][x] + map[y][x-1] + map[y][x+1];
            max = Math.max(max, temp);
        }
        if (y-1 >= 0 && y+1 < N && x+1 < M) {
            int temp = map[y][x] + map[y-1][x] + map[y+1][x] + map[y][x+1];
            max = Math.max(max, temp);
        }
        if (y+1 < N && x-1 >= 0 && x+1 < M) {
            int temp = map[y][x] + map[y][x-1] + map[y][x+1] + map[y+1][x];
            max = Math.max(max, temp);
        }
        if (y-1 >= 0 && y+1 < N && x-1 >= 0) {
            int temp = map[y][x] + map[y-1][x] + map[y+1][x] + map[y][x-1];
            max = Math.max(max, temp);
        }
    }
}
