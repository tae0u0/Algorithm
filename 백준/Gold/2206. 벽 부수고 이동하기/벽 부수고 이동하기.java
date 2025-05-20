import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][][] visited;
    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1][2];

        for (int i = 1; i <= N; i++) {
            String line = br.readLine();
            for (int j = 1; j <= M; j++) {
                map[i][j] = line.charAt(j - 1) - '0';
            }
        }

        int result = bfs();
        System.out.println(result);
    }

    static int bfs() {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(1, 1, 1, 0));
        visited[1][1][0] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (cur.y == N && cur.x == M) {
                return cur.count;
            }

            for (int d = 0; d < 4; d++) {
                int ny = cur.y + dirs[d][0];
                int nx = cur.x + dirs[d][1];

                if (ny >= 1 && ny <= N && nx >= 1 && nx <= M) {
                    // 이동 가능
                    if (map[ny][nx] == 0 && !visited[ny][nx][cur.breakCount]) {
                        visited[ny][nx][cur.breakCount] = true;
                        q.offer(new Node(ny, nx, cur.count + 1, cur.breakCount));
                    }

                    // 벽인데 아직 안 부셨을 때
                    else if (map[ny][nx] == 1 && cur.breakCount == 0 && !visited[ny][nx][1]) {
                        visited[ny][nx][1] = true;
                        q.offer(new Node(ny, nx, cur.count + 1, 1));
                    }
                }
            }
        }

        return -1;
    }

    static class Node {
        int y, x, count, breakCount;

        public Node(int y, int x, int count, int breakCount) {
            this.y = y;
            this.x = x;
            this.count = count;
            this.breakCount = breakCount;
        }
    }
}
