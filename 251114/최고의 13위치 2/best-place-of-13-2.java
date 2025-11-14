import java.util.Scanner;
import java.lang.Math;

public class Main {
    static int n;
    static int[][] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                arr[i][j] = sc.nextInt();
        
        int maxNum = Integer.MIN_VALUE;
        for(int i = 0; i<n; i++){
            for(int j = 0; j < n-2; j++) {
                for(int k = i; k<n; k++) {
                    for(int p = 0; p < n-2; p++) {
                        if(i == k && j + 2 >= p) continue;
                        int sum = arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[k][p] + arr[k][p+1] + arr[k][p+2];
                        maxNum = Math.max(sum, maxNum);
                    }
                }
            }
        }

        System.out.print(maxNum);

    }
}