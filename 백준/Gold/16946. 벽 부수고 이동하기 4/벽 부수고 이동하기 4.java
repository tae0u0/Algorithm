import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map, tagMap;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int tagNum = 1;
    static boolean[][] isTag;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        initMap(br);
        StringBuilder sb = new StringBuilder();


        for (int row = 0; row < N; row++) {
            for (int col = 0; col < M; col++) {
                if(map[row][col] == 0 && !isTag[row][col]) {
                    bfs(row, col);
                }
            }
        }

        Set<Integer> set = new HashSet<>();
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < M; col++) {
                if(!isTag[row][col]) {
                    int sum = 0;
                    for (int dir = 0; dir < 4; dir++) {
                        int ny = row + dy[dir];
                        int nx = col + dx[dir];
                        if (isRange(ny, nx) && isTag[ny][nx] && !set.contains(tagMap[ny][nx])) {
                            sum += map[ny][nx];
                            set.add(tagMap[ny][nx]);
                        }
                    }
                    sb.append((sum + 1) % 10);
                    set.clear();
                } else{
                    sb.append(0);
                }
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    private static int bfs(int row, int col) {
        Queue<int[]> q = new LinkedList<>();
        Queue<int[]> point = new LinkedList<>();
        int[] start = new int[]{row, col};
        q.add(start);
        point.add(start);
        int cnt = 1;
        isTag[row][col] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int cy = cur[0];
            int cx = cur[1];

            for (int dir = 0; dir < 4; dir++) {
                int ny = cy + dy[dir];
                int nx = cx + dx[dir];

                if(isRange(ny, nx) && !isTag[ny][nx] && map[ny][nx] == 0) {
                    int[] next = {ny, nx};
                    q.add(next);
                    point.add(next);
                    isTag[ny][nx] = true;
                    cnt++;
                }
            }
        }

        while(!point.isEmpty()) {
            int[] p = point.poll();
            map[p[0]][p[1]] = cnt;
            tagMap[p[0]][p[1]] = tagNum;
        }
        tagNum++;

        return cnt % 10;
    }

    private static void initMap(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int row = 0; row < N; row++) {
            String line = br.readLine();
            for (int col = 0; col < M; col++) {
                map[row][col] = line.charAt(col) - '0';
            }
        }

        isTag = new boolean[N][M];
        tagMap = new int[N][M];
    }

    private static boolean isRange(int y, int x) {
        return y < N && y >= 0 && x < M && x >= 0;
    }
}