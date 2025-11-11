import java.util.Scanner;

public class Main {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n, m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        Character[][] arr = new Character[n][m];

        int curX = 0, curY = 0;
        arr[curY][curX] = 'A'; 
        int cnt = 1;               
        int dirNum = 0;          

        while (cnt < n * m) {
            int nx = curX + dx[dirNum];
            int ny = curY + dy[dirNum];

            if (isRange(nx, ny) && arr[ny][nx] == null) {
                arr[ny][nx] = (char) ('A' + (cnt % 26));
                curX = nx;  
                curY = ny;
                cnt++;
            } else {
                dirNum = (dirNum + 1) % 4;  
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        sc.close();
    }

    private static boolean isRange(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
