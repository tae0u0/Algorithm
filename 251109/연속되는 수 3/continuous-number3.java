import java.util.Scanner;
import java.lang.Math;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        
        int max_num = 1;
        int cnt = 1;
        for (int i = 0; i < n-1; i++) {
            if((arr[i+1] > 0 && arr[i] > 0) || (arr[i+1] < 0 && arr[i] < 0)){
                cnt++;
                max_num = Math.max(max_num, cnt);
            } else {
                cnt = 1;
            }
        }
        System.out.print(max_num);
    }
}