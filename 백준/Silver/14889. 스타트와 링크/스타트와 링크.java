import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main{
    static int[][] player;
    static int[] start_index, link_index;
    static int N, start_sum, link_sum, min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        player = new int[N][N];
        start_index = new int[N/2];
        link_index = new int[N/2];
        for (int i = 0; i < N; i++) {
            player[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        start_index[0] = 0;
        building(0, 0);
        System.out.println(min);
    }

    static void building(int level, int num) {
        if (level == N/2) {
            get_minimum();
            return;
        }

        for (int i = num; i < N; i++) {
            start_index[level] = i;
            building(level + 1, i+1);
        }
    }

    static void get_minimum() {
        int index = 0;
        for (int i = 0; i < N; i++) {
            boolean isStartPlayer = false;
            for (int j = 0; j < N / 2; j++) {
                if (start_index[j] == i) {
                    isStartPlayer = true;
                    break;
                }
            }
            if (!isStartPlayer) {
                link_index[index++] = i;
            }
        }
        start_sum = sum(start_index);
        link_sum = sum(link_index);

        min = Math.min(min, Math.abs(start_sum - link_sum));
    }

    static int sum(int[] player_index){
        int first, second, sum = 0;
        for (int i = 0; i < N/2 -1; i++) {
            for (int j = i+1; j < N/2; j++) {
                first = player_index[i];
                second = player_index[j];
                sum += player[first][second] + player[second][first];
            }
        }
        return sum;
    }
}