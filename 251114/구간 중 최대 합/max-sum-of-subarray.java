import java.util.Scanner;
import java.lang.Math;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        
        int maxNum = Integer.MIN_VALUE;
        for(int i = 0; i <= n - k; i++) {
            int cnt = 0;
            for(int j = i; j < i+k; j++) {
                cnt += arr[j];
            }
            maxNum = Math.max(cnt, maxNum);
        }

        System.out.print(maxNum);
    }
}