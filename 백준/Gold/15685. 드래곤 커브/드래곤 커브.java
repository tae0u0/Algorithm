import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static boolean[][] map;
    static int[][] dirs = {
            {1, 0}, {0, -1}, {-1, 0}, {0, 1}
    };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new boolean[101][101];
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            int d =  Integer.parseInt(input[2]);
            int g = Integer.parseInt(input[3]);
            solve(x, y, d, g);
        }

        int count = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if(map[i][j] && map[i][j+1] && map[i+1][j] && map[i+1][j+1])
                    count++;
            }
        }

        System.out.println(count);
    }

    static void solve(int x, int y, int d, int g) {
        List<Integer> directions = new ArrayList<>();
        directions.add(d);

        for (int i = 0; i < g; i++) {
            for (int j = directions.size()-1; j >= 0 ; j--) {
                directions.add((directions.get(j)+1)%4);
            }
        }

        map[y][x] = true;
        for (Integer dir : directions) {
            x += dirs[dir][0];
            y += dirs[dir][1];
            if(x >= 0 && x < 101 && y >= 0 && y < 101) {
                map[y][x] = true;
            }
        }
    }
}
