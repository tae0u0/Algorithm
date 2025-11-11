import java.util.Scanner;

public class Main {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[][] arr = new int[n][n];
        arr[n-1][n-1] = n*n;
        int curX = n-1, curY = n-1;
        int cnt = n*n;
        int dirNum = 2;
        while(cnt > 1){
            int nx = curX + dx[dirNum];
            int ny = curY + dy[dirNum];
            if(isRange(nx, ny) && arr[ny][nx] == 0) {
                arr[ny][nx] = --cnt;
                curX = nx;
                curY = ny;
            } else {
                dirNum = (dirNum + 3) % 4;
            }
        }

        for(int i = 0; i<n; i++) {
            for(int j= 0; j<n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        
    }   

    private static boolean isRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }
}