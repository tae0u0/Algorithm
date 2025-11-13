import java.util.Scanner;
import java.lang.Math;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        int rst = Integer.MIN_VALUE;
        for (int i = 0; i< n-2; i++) {
            for(int j= i+1; j < n-1; j++) {
                for(int k = j+1; k < n; k++) {
                    int maxNum = Math.max(arr[i], arr[j]);
                    maxNum = Math.max(maxNum, arr[k]);
                    int divisor = 1;
                    boolean flag = true;
                    int first = arr[i];
                    int second = arr[j];
                    int third = arr[k];
                    while(maxNum / divisor > 0) {
                        if(first % 10  + second % 10 + third % 10 >= 10) {
                            flag = false;
                            break;
                        }
                        first /= 10;
                        second /= 10;
                        third /= 10;
                        divisor *= 10;
                    }
                    if(flag) rst = Math.max(rst, arr[i] + arr[j] + arr[k]);
                }
            }
        }
        if(rst == Integer.MIN_VALUE) System.out.print(-1);
        else System.out.print(rst);


    }
}