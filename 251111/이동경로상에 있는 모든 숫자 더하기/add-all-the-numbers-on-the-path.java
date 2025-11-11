import java.util.Scanner;

public class Main {
    static int n, t;
    static int[] dx = {1, 0 , -1, 0};
    static int[] dy = {0, 1 , 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        t = sc.nextInt();
        char[] commands = sc.next().toCharArray();
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        int dirNum = 3;
        int curX = n / 2, curY = n / 2;
        int cnt = board[curY][curX];
        for(int i = 0; i < t; i++) {
            if(commands[i] == 'R') {
                dirNum = (dirNum + 1) % 4;
            } else if(commands[i] == 'L') {
                dirNum = (dirNum + 3) % 4;
            } else {
                int nx = curX + dx[dirNum];
                int ny = curY + dy[dirNum];
                if(isRange(nx, ny)){
                    cnt += board[ny][nx];
                    curX = nx;
                    curY = ny;
                }
            }
        }

        System.out.print(cnt);

    }

    private static boolean isRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }
}