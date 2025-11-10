import java.util.Scanner;
public class Main {
    static int[] dx = {1, 0 , -1, 0};
    static int[] dy = {0, 1 , 0, -1};
    static int n;
    static boolean[][] colors;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();
        // Please write your code here.
        colors = new boolean[n+1][n+1];

        for(int i = 0; i<m; i++){
            int row = sc.nextInt();
            int col = sc.nextInt();
            colors[row][col] = true;
            if(isSafe(col, row)) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }

    private static boolean isSafe(int x, int y) {
        int cnt = 0;
        for(int i = 0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(isRange(nx, ny) && colors[ny][nx]) {
                cnt++;
            }
        }

        if(cnt == 3) return true;
        else return false;
    }

    private static boolean isRange(int x, int y) {
        return x > 0 && x <= n && y > 0 && y <= n;
    }
}