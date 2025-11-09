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
        // Please write your code here.
        int max_num = 1;
        int cnt = 1;
        for (int i = 0; i < n-1; i++) {
            if(arr[i+1] > arr[i]){
                cnt++;
                max_num = Math.max(max_num, cnt);
            } else {
                cnt = 1;
            }
        }

        System.out.print(max_num);

    }
}