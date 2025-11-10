import java.util.Scanner;
public class Main {
    static int[] dx = {1, 0 , -1, 0};
    static int[] dy = {0, 1 , 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] arr = sc.next().toCharArray();
        int curX = 0, curY = 0;
        int dirNum = 3;
        int time = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 'L') {
                dirNum = (dirNum + 3) % 4;
                time++;
            } else if(arr[i] == 'R') {
                dirNum = (dirNum + 1) % 4;
                time++;
            } else if(arr[i] == 'F') {
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