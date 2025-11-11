import java.util.Scanner;
import java.lang.Math;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int minNum = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for(int j = 0; j < n; j++) {
                cnt += Math.abs(i - j) * a[j];
            }
            minNum = Math.min(minNum, cnt);
        }
        System.out.print(minNum);
    }
}