import java.util.Scanner;

public class Main {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N, T, R, C;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        T = sc.nextInt();
        R = sc.nextInt() - 1; // y값
        C = sc.nextInt() - 1; // x값
        String D = sc.next();

        int dirNum = -1;
        if(D.equals("U")) {
                dirNum = 3;
        } else if(D.equals("D")) {
                dirNum = 1;
        } else if(D.equals("R")) {
                dirNum = 0;
        } else if(D.equals("L")) {
                dirNum = 2;
        };

        int curX = C, curY = R;
        while(T-- > 0){
            int nx =  curX + dx[dirNum];
            int ny =  curY + dy[dirNum];
            if(isRange(nx, ny)) {
                curX = nx;
                curY = ny;
            } else {
                dirNum = (dirNum + 2) % 4;
            }
        }

        System.out.print((curY + 1) + " " + (curX + 1));
    }

    private static boolean isRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}