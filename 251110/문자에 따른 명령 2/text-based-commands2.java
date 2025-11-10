import java.util.Scanner;

public class Main {
    // 동남서북
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int dirNum = 3;
        int curX = 0, curY = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'L') {
                dirNum = (dirNum + 3) % 4;
            } else if(s.charAt(i) == 'R') {
                dirNum = (dirNum + 1) % 4;
            } else {
                curX += dx[dirNum];
                curY += dy[dirNum];
            }
        }
        System.out.print(curX + " " + curY);
    }
}