import java.util.Scanner;
import java.lang.Math;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        
        int minNum = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            int index = i;
            int cnt = 0;
            for(int k = 0; k < n; k++) {
                cnt += k * arr[index];
                index = (index + 1) % 5;
            }
            minNum = Math.min(cnt, minNum);
        }
        System.out.print(minNum);
    }
}