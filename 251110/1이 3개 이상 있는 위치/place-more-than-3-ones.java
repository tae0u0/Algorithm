import java.util.Scanner;
public class Main {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int cnt = 0;
                for(int k = 0; k<4; k++){
                    int nx = j + dx[k];
                    int ny = i + dy[k];
                    if(isRange(nx, ny) && arr[ny][nx] == 1) cnt++;
                }
                
                if(cnt >= 3) result++;
            }
        }

        System.out.print(result);
    }

    private static boolean isRange(int curX, int curY) {
        return curX >= 0 && curX < n && curY >= 0 && curY < n;
    }
}