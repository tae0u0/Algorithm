import java.util.Scanner;
public class Main {
    static int n, m;
    static int[] dx = {1, 1, 0, -1 , -1, -1, 0, 1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    static char[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();   // 행
        m = sc.nextInt();   // 열
        arr = new char[n][m];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next().toCharArray();
        }
        
        int cnt = 0;
        for(int row = 0; row < n; row++) {
            for(int col = 0; col < m; col++) {
                for(int dir = 0; dir < 8; dir++) {
                    int nx = col + dx[dir] * 2;
                    int ny = row + dy[dir] * 2;
                    if(isRange(nx, ny) && lee(col, row, dir)) {
                        cnt++;
                    }
                }
            }
        }

        System.out.print(cnt);
    }

    private static boolean isRange(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    private static boolean lee(int x, int y, int dir) {
        if(arr[y][x] != 'L') return false;
        if(arr[y + dy[dir]][x + dx[dir]] != 'E') return false;
        if(arr[y + dy[dir] * 2][x + dx[dir] * 2] != 'E') return false;
        return true;
    }
}