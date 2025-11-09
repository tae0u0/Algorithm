import java.util.Scanner;
import java.lang.Math;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        
        int max_num = 0;
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            if(arr[i] > t) {
                cnt++;
                max_num = Math.max(max_num, cnt);
            } else {
                cnt = 0;
            }
        }

        System.out.print(max_num);
    }
}