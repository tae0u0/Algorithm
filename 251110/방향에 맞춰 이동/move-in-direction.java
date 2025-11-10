import java.util.Scanner;
public class Main {
    //  동, 남, 서, 북
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int curX = 0, curY = 0;
        for (int i = 0; i < n; i++) {
            char direction = sc.next().charAt(0);
            int distance = sc.nextInt();
            // Please write your code here.
            for(int k = 0; k<distance; k++) {
                if(direction == 'E') {
                    curX += dx[0];
                    curY += dy[0];
                } else if(direction == 'S') {
                    curX += dx[1];
                    curY += dy[1];
                } else if(direction == 'W') {
                    curX += dx[2];
                    curY += dy[2];
                } else if(direction == 'N'){
                    curX += dx[3];
                    curY += dy[3];
                }
            }
        }
        System.out.print(curX + " " + curY);
    }
}