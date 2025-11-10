import java.util.Scanner;
public class Main {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n, m;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int[][] arr = new int[n][m];
        // Please write your code here.
        int dirNum = 0;
        int curX = 0, curY = 0;
        int nx = curX, ny = curY;
        int cnt = 1;
        while(cnt <= n * m) {
            while(isRange(nx, ny) && arr[ny][nx] == 0){
                curX = nx;
                curY = ny;
                arr[curY][curX] = cnt++;
                nx = curX + dx[dirNum];
                ny = curY + dy[dirNum];
            }
            dirNum = (dirNum + 1) % 4;
            nx = curX + dx[dirNum];
            ny = curY + dy[dirNum];
        }

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean isRange(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}