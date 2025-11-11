import java.util.Scanner;

public class Main {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static char[][] grid;
    static int n;
    static int curX, curY;
    static int curDirNum;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new char[n][n];

        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < n; j++) {
                grid[i][j] = s.charAt(j);
            }
        }

        int startNum = sc.nextInt();
        getInitialPosition(startNum); 

        int cnt = 0;
        while (curX >= 0 && curX < n && curY >= 0 && curY < n) {
            curDirNum = reflect(grid[curY][curX], curDirNum);
            cnt++;

            curX += dx[curDirNum];
            curY += dy[curDirNum];
        }

        System.out.print(cnt);
    }

    private static int reflect(char cell, int dir) {
        if (cell == '/') {
            return 3 - dir;
        } else if (cell == '\\') {
            return dir ^ 1;
        } else {
            return dir;
        }
    }

    private static void getInitialPosition(int startNum) {
        int idx = startNum - 1;
        curDirNum = ((idx) / n + 1) % 4; 

        int offset = idx % n;
        if (curDirNum == 0) {   
            curX = 0;
            curY = n - 1 - offset;
        } else if (curDirNum == 1) {  
            curX = offset;
            curY = 0;
        } else if (curDirNum == 2) {  
            curX = n - 1;
            curY = offset;
        } else {                     
            curX = n - 1 - offset;
            curY = n - 1;
        }
    }
}
