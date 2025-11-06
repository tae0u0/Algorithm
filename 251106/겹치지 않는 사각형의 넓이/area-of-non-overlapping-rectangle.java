import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ax1 = sc.nextInt() + 1000;
        int ay1 = sc.nextInt() + 1000;
        int ax2 = sc.nextInt() + 1000;
        int ay2 = sc.nextInt() + 1000;
        int bx1 = sc.nextInt() + 1000;
        int by1 = sc.nextInt() + 1000;
        int bx2 = sc.nextInt() + 1000;
        int by2 = sc.nextInt() + 1000;
        int mx1 = sc.nextInt() + 1000;
        int my1 = sc.nextInt() + 1000;
        int mx2 = sc.nextInt() + 1000;
        int my2 = sc.nextInt() + 1000;
        // Please write your code here.

        int[][] arr = new int[2001][2001];
        for(int i = ay1; i < ay2; i++) {
            for(int j = ax1; j <ax2; j++){
                arr[i][j]++;
            }
        }

        for(int i = by1; i < by2; i++) {
            for(int j = bx1; j < bx2; j++){
                arr[i][j]++;
            }
        }

        for(int i = my1; i < my2; i++) {
            for(int j = mx1; j < mx2; j++){
                arr[i][j] = 0;
            }
        }

        int cnt = 0;

         for(int i = 0; i < 2001; i++) {
            for(int j = 0; j < 2001; j++){
                if(arr[i][j] > 0) cnt++;
            }
        }
        System.out.print(cnt);
    }
}