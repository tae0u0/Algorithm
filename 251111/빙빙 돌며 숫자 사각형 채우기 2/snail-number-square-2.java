import java.util.Scanner;
public class Main {
    static int[] dx = {1, 0 , -1, 0};
    static int[] dy = {0, 1 , 0, -1};
    static int n, m;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        int[][] arr = new int[n][m];
        arr[0][0] = 1;
        int curX = 0, curY = 0;
        int dirNum = 1;
        int cnt = 1;

        while(cnt < n * m) {
            int nx = curX + dx[dirNum];
            int ny = curY + dy[dirNum];
            if(isRange(nx, ny) && arr[ny][nx] == 0) {
                arr[ny][nx] = ++cnt;
                curX = nx;
                curY = ny;
            } else {
                dirNum = (dirNum + 1) % 4;
            }
        }

        for(int i = 0; i < n; i++) {
            for(int k = 0; k < m; k++) {
                System.out.print(arr[i][k] + " ");
            }
            System.out.println();
        }
    }

    private static boolean isRange(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}