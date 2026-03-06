import java.io.*;
import java.util.*;

public class Main {
    static int T, H, W;
    static char[][] map;
    static boolean[][] visited;
    static List<int[]>[] waitDoors;
    static boolean[] key;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            map = new char[H + 2][W + 2];
            visited = new boolean[H + 2][W + 2];
            key = new boolean[26];
            waitDoors = new ArrayList[26];
            for (int i = 0; i < 26; i++) waitDoors[i] = new ArrayList<>();

            for (int i = 0; i < H + 2; i++) Arrays.fill(map[i], '.');

            for (int i = 1; i <= H; i++) {
                String line = br.readLine();
                for (int j = 1; j <= W; j++) {
                    map[i][j] = line.charAt(j - 1);
                }
            }

            String startKeys = br.readLine();
            if (!startKeys.equals("0")) {
                for (char c : startKeys.toCharArray()) key[c - 'a'] = true;
            }

            System.out.println(bfs());
        }
    }

    private static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        visited[0][0] = true;
        int count = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];

                if (ny < 0 || ny >= H + 2 || nx < 0 || nx >= W + 2 || visited[ny][nx] || map[ny][nx] == '*') continue;

                char cell = map[ny][nx];
                if (cell >= 'A' && cell <= 'Z') {
                    if (key[cell - 'A']) {
                        visited[ny][nx] = true;
                        q.add(new int[]{ny, nx});
                    } else {
                        waitDoors[cell - 'A'].add(new int[]{ny, nx});
                    }
                } else if (cell >= 'a' && cell <= 'z') {
                    key[cell - 'a'] = true;
                    visited[ny][nx] = true;
                    q.add(new int[]{ny, nx});
                    for (int[] door : waitDoors[cell - 'a']) {
                        if (!visited[door[0]][door[1]]) {
                            visited[door[0]][door[1]] = true;
                            q.add(door);
                        }
                    }
                } else if (cell == '$') {
                    count++;
                    visited[ny][nx] = true;
                    q.add(new int[]{ny, nx});
                } else {
                    visited[ny][nx] = true;
                    q.add(new int[]{ny, nx});
                }
            }
        }
        return count;
    }
}