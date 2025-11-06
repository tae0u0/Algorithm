import java.util.Scanner;
import java.lang.Math;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rect1_x1 = sc.nextInt() + 1000;
        int rect1_y1 = sc.nextInt() + 1000;
        int rect1_x2 = sc.nextInt() + 1000;
        int rect1_y2 = sc.nextInt() + 1000;
        int rect2_x1 = sc.nextInt() + 1000;
        int rect2_y1 = sc.nextInt() + 1000;
        int rect2_x2 = sc.nextInt() + 1000;
        int rect2_y2 = sc.nextInt() + 1000;
        
        int[][] arr = new int[2001][2001];
        for(int i = rect1_y1; i < rect1_y2; i++) {
            for(int j = rect1_x1; j < rect1_x2; j++) {
                arr[i][j]++;
            }
        }

        for(int i = rect2_y1; i < rect2_y2; i++) {
            for(int j = rect2_x1; j < rect2_x2; j++) {
                arr[i][j] = 0;
            }
        }

        int min_x = 3000, min_y = 3000, max_x = 0, max_y= 0;
        for(int i = rect1_y1; i < rect1_y2; i++) {
            for(int j = rect1_x1; j < rect1_x2; j++) {
                if(arr[i][j] == 1) {
                    min_x = Math.min(min_x, j);
                    min_y = Math.min(min_y, i);
                    max_x = Math.max(max_x, j);
                    max_y = Math.max(max_y, i);
                }
            }
        }

        System.out.print((max_x - min_x + 1) * (max_y - min_y + 1));
    }
}