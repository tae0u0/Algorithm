import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static int N, M;
    static int[][] map;
    static ArrayList<Cctv> cctv = new ArrayList<>();
    static int min = Integer.MAX_VALUE;
    static int[][] dirs = {
            {0, 1}, {1, 0}, {0, -1}, {-1, 0}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                int input = Integer.parseInt(s[j]);
                map[i][j] = input;

                if (input >= 1 && input <= 5) {
                    cctv.add(new Cctv(j, i, input));
                }
            }
        }

        solve(0, map);
        System.out.println(min);

    }

    static void solve(int level, int[][] cur_map) {
        if (level == cctv.size()) {
            min = Math.min(min, countBlind(cur_map));
            return;
        }

        Cctv cur_cctv = cctv.get(level);
        int[][] copy_map;

        for (int[] direction : getDirections(cur_cctv.type)) {
            copy_map = copy(cur_map);
            for (int type : direction) {
                watch(copy_map, cur_cctv.x, cur_cctv.y, type);
            }
            solve(level + 1, copy_map);
        }
    }

    private static int[][] copy(int[][] original) {
        int[][] copy_map = new int[N][M];
        for (int i = 0; i < N; i++) {
            System.arraycopy(original[i], 0, copy_map[i], 0, M);
        }
        return copy_map;
    }

    private static ArrayList<int[]> getDirections(int type) {
        ArrayList<int[]> directions = new ArrayList<>();
        switch (type) {
            case 1:
                for (int i = 0; i < 4; i++) {
                    directions.add(new int[]{i});
                }
                break;
            case 2:
                directions.add(new int[]{0, 2});
                directions.add(new int[]{1, 3});
                break;
            case 3:
                for (int i = 0; i < 4; i++) {
                    directions.add(new int[]{i, (i + 1) % 4});
                }
                break;
            case 4:
                for (int d = 0; d < 4; d++) {
                    directions.add(new int[]{d, (d + 1) % 4, (d + 2) % 4});
                }
                break;
            case 5:
                directions.add(new int[]{0, 1, 2, 3});
                break;
        }
        return directions;
    }

    private static void watch(int[][] copy_map, int x, int y, int dir) {
        int nx = x + dirs[dir][0];
        int ny = y + dirs[dir][1];

        while (nx >= 0 && ny >= 0 && nx < M && ny < N && copy_map[ny][nx] != 6) {
            if (copy_map[ny][nx] == 0) {
                copy_map[ny][nx] = -1;
            }
            nx += dirs[dir][0];
            ny += dirs[dir][1];
        }
    }

    private static int countBlind(int[][] map) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    static class Cctv {
        int x, y, type;

        public Cctv(int x, int y, int type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }
}
