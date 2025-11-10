import java.util.Scanner;
public class Main {
    static int[] dx = {1, 0 , -1, 0};
    static int[] dy = {0, 1 , 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int curX = 0, curY = 0;
        int dirNum;
        int time = 0;
        for(int i = 0; i < n; i++){
            char dir = sc.next().charAt(0);
            int dist = sc.nextInt();

            if(dir == 'E') {
                dirNum = 0;
            } else if(dir == 'S') {
                dirNum = 1;
            } else if(dir == 'W') {
                dirNum = 2;
            } else {
                dirNum = 3;
            }
            for(int k = 0; k<dist; k++){
                curX += dx[dirNum];
                curY += dy[dirNum];
                time++;
                if(curX == 0 && curY == 0) {
                    System.out.print(time);
                    System.exit(0);
                }
            }

        }
        System.out.print(-1);
    }
}