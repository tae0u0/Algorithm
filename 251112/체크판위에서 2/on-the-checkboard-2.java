import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();   // 행 
        int C = sc.nextInt();   // 열
        char[][] grid = new char[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                grid[i][j] = sc.next().charAt(0);
            }
        }

        if(grid[0][0] == grid[R-1][C-1]) {
            System.out.print(0);
            System.exit(0);
        }

        int cnt = 0;
        for(int i = 1; i<R-2; i++) {
            for(int j = 1; j <C-2; j++) {
                if(grid[i][j] != grid[0][0]) {
                    for(int k = i+1; k<R-1; k++) {
                        for(int p = j + 1; p<C-1; p++) {
                            if(grid[k][p] != grid[R-1][C-1]) cnt++;
                        }
                    }
                }
            }
        }

        System.out.print(cnt);

    }
}