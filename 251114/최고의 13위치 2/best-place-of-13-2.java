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
                    int p;
                    if(j + 3 < n -2) p = j+3;
                    else {
                        p = 0;
                        k++;
                        if(k >= n) break;
                    }
                    for(; p<n-2; p++) {
                        int sum = arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[k][p] + arr[k][p+1] + arr[k][p+2];
                        maxNum = Math.max(sum, maxNum);
                    }
                }
            }
        }

        System.out.print(maxNum);

    }
}