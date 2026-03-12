import java.io.*;
import java.util.*;

public class Main {
    private static int H, W;
    private static int[][] map;
    private static Queue<int[]> cheesePoints = new LinkedList<>(); // 현재 남은 치즈 좌표들
    private static Queue<int[]> airPoints = new LinkedList<>();    // 새로 공기가 된 좌표들
    private static int[] dy = {-1, 1, 0, 0};
    private static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        init();

        int lastCheeseCount = 0;
        int time = 0;

        while (true) {
            // 1. 외부 공기 확산 (외부 공기는 map 값을 2로 변경)
            updateAir();

            // 2. 이번 단계에서 녹을 치즈(공기와 접촉한 치즈) 찾기
            int currentMeltCount = findAndMelt();

            if (currentMeltCount == 0) break; // 더 이상 녹을 치즈가 없으면 종료

            lastCheeseCount = currentMeltCount;
            time++;
        }

        System.out.println(time);
        System.out.println(lastCheeseCount);
    }

    /**
     * 외부 공기(2)를 확산시키는 메서드
     * airPoints에 담긴 지점부터 BFS를 수행하여 빈 공간(0)을 공기(2)로 바꿉니다.
     */
    private static void updateAir() {
        while (!airPoints.isEmpty()) {
            int[] cur = airPoints.poll();
            int cy = cur[0];
            int cx = cur[1];

            for (int dir = 0; dir < 4; dir++) {
                int ny = cy + dy[dir];
                int nx = cx + dx[dir];

                if (isRange(ny, nx) && map[ny][nx] == 0) {
                    map[ny][nx] = 2; // 외부 공기로 전환
                    airPoints.add(new int[]{ny, nx});
                }
            }
        }
    }

    /**
     * 현재 치즈들 중 공기(2)와 맞닿은 치즈를 찾아 녹입니다.
     */
    private static int findAndMelt() {
        List<int[]> toMelt = new ArrayList<>();
        int initialSize = cheesePoints.size();

        // 현재 모든 치즈 위치를 확인
        for (int i = 0; i < initialSize; i++) {
            int[] p = cheesePoints.poll();
            if (isExposed(p[0], p[1])) {
                toMelt.add(p); // 녹을 대상
            } else {
                cheesePoints.add(p); // 아직 안 녹음 (다음 턴에 다시 확인)
            }
        }

        // 치즈를 녹이고, 해당 위치를 다음 공기 확산의 시작점으로 지정
        for (int[] p : toMelt) {
            map[p[0]][p[1]] = 2;
            airPoints.add(p); // 다음 단계에서 이 위치부터 공기가 확산됨
        }

        return toMelt.size();
    }

    /**
     * 상하좌우 중 하나라도 외부 공기(2)와 닿아있는지 확인
     */
    private static boolean isExposed(int y, int x) {
        for (int dir = 0; dir < 4; dir++) {
            int ny = y + dy[dir];
            int nx = x + dx[dir];
            if (isRange(ny, nx) && map[ny][nx] == 2) {
                return true;
            }
        }
        return false;
    }

    private static boolean isRange(int y, int x) {
        return y >= 0 && y < H && x >= 0 && x < W;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        map = new int[H][W];

        for (int row = 0; row < H; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col < W; col++) {
                int val = Integer.parseInt(st.nextToken());
                map[row][col] = val;
                if (val == 1) {
                    cheesePoints.add(new int[]{row, col});
                }
            }
        }

        // 가장자리 (0,0)은 항상 외부 공기라고 가정하고 시작
        map[0][0] = 2;
        airPoints.add(new int[]{0, 0});
    }
}