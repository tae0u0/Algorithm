import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] rooms;
    static int N, M;
    static int r, c, dir;
    static final int[][] DIRECTION = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        rooms = new int[N][M];

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        dir = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            rooms[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int result = clean(r, c);
        System.out.println(result);
    }

    static int clean(int y, int x) {
        int count = 0;
        int cur_y = y;
        int cur_x = x;

        if (rooms[cur_y][cur_x] == 0) {
            rooms[cur_y][cur_x] = -1;
            count++;
        }

        while (true) {
            boolean cleaned = false;
            for (int i = 0; i < 4; i++) {
                dir = (dir + 3) % 4;
                int next_y = cur_y + DIRECTION[dir][0];
                int next_x = cur_x + DIRECTION[dir][1];

                if (next_y >= 0 && next_y < N && next_x >= 0 && next_x < M && rooms[next_y][next_x] == 0) {
                    rooms[next_y][next_x] = -1;
                    cur_y = next_y;
                    cur_x = next_x;
                    count++;
                    cleaned = true;
                    break;
                }
            }

            if (!cleaned) {
                int back_y = cur_y - DIRECTION[dir][0];
                int back_x = cur_x - DIRECTION[dir][1];

                if (back_y >= 0 && back_y < N && back_x >= 0 && back_x < M && rooms[back_y][back_x] != 1) {
                    cur_y = back_y;
                    cur_x = back_x;
                } else {
                    break;
                }
            }
        }
  
        return count;
    }
}
