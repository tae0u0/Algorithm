import java.io.*;
import java.util.*;

public class Main {
    static int N, M, B;
    static int[][] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int minTime = Integer.MAX_VALUE;
        int maxHeight = 0;
        for (int i = 0; i <= 256; i++) {
            if (isAvailable(i)) {
                int time = countTime(i);
                if (time <= minTime) {
                    minTime = time;
                    maxHeight = i;
                }
            }
        }

        System.out.println(minTime + " " + maxHeight);

    }

    private static boolean isAvailable(int level) {
        int leftBlock = B;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                leftBlock -= level - map[i][j];
            }
        }

        return leftBlock >= 0;
    }

    private static int countTime(int level) {
        int time = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] > level) time += (map[i][j] - level) * 2;
                else if(map[i][j] < level) time += level - map[i][j];
            }
        }
        return time;
    }
}
