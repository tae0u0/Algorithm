import java.io.*;
import java.util.*;

public class Main {
    static int R, C, T;
    static int[][] map, newMap;
    static int[][] dirs = {
            {-1, 0}, {0, 1}, {1, 0}, {0, -1}
    };
    static int purifierX = -1, purifierY = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        newMap = new int[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                int value = Integer.parseInt(st.nextToken());
                map[i][j] = value;
                if(value == -1 && purifierY == -1){
                    purifierY = i;
                    purifierX = j;
                }
            }
        }

        while(T-- > 0){
            spread();
            blow();

            for (int i = 0; i < R; i++) {
                map[i] = Arrays.copyOf(newMap[i], C);
            }

            for (int i = 0; i < R; i++) {
                Arrays.fill(newMap[i], 0);
            }
        }

        int answer = count();
        System.out.println(answer);
    }

    private static void spread() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                newMap[i][j] = map[i][j];
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(map[i][j] >= 5) { 
                    int child = map[i][j] / 5;
                    int spreadCount = 0;

                    for (int k = 0; k < 4; k++) {
                        int ny = i + dirs[k][0];
                        int nx = j + dirs[k][1];

                        if(ny >= 0 && nx >= 0 && ny < R && nx < C && map[ny][nx] != -1) {
                            newMap[ny][nx] += child;
                            spreadCount++;
                        }
                    }
                    newMap[i][j] -= child * spreadCount;
                }
            }
        }
    }

    private static void blow() {
        // 위
        for (int i = purifierY - 1; i > 0; i--) {
            newMap[i][0] = newMap[i-1][0];
        }

        for (int j = 0; j < C-1; j++) {
            newMap[0][j] = newMap[0][j+1];
        }

        for (int i = 0; i < purifierY; i++) {
            newMap[i][C-1] = newMap[i+1][C-1];
        }

        for (int j = C-1; j > 1; j--) {
            newMap[purifierY][j] = newMap[purifierY][j-1];
        }

        // 아래
        newMap[purifierY][1] = 0;

        int underPurifierY = purifierY + 1;

        for (int i = underPurifierY + 1; i < R-1; i++) {
            newMap[i][0] = newMap[i+1][0];
        }
        
        for (int j = 0; j < C-1; j++) {
            newMap[R-1][j] = newMap[R-1][j+1];
        }

        for (int i = R-1; i > underPurifierY; i--) {
            newMap[i][C-1] = newMap[i-1][C-1];
        }

        for (int j = C-1; j > 1; j--) {
            newMap[underPurifierY][j] = newMap[underPurifierY][j-1];
        }

        newMap[purifierY][1] = 0;
        newMap[underPurifierY][1] = 0;

        newMap[purifierY][0] = -1;
        newMap[underPurifierY][0] = -1;
    }

    private static int count(){
        int answer = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(map[i][j] > 0) {
                    answer += map[i][j];
                }
            }
        }
        return answer;
    }
}