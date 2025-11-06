import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int color;
        int[][] arr = new int[201][201];
        for (int i = 0; i < n; i++) {
            int x1 = sc.nextInt() + 100;
            int y1 = sc.nextInt() + 100;
            int x2 = sc.nextInt() + 100;
            int y2 = sc.nextInt() + 100;

            if(i % 2 == 0) color = 1;
            else color = 2;
            for(int j = y1; j < y2; j++) {
                for(int k = x1; k<x2; k++) {
                    arr[j][k] = color;
                }
            }
        }
        // Please write your code here.

        int cnt = 0;
        for(int j = 0; j < 201; j++) {
            for(int k = 0; k< 201; k++) {
                if(arr[j][k] == 2) cnt++;
            }
        }
        System.out.print(cnt);
    }
}