import java.util.Scanner;
import java.lang.Math;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }

        int cnt = 0;
        int minNum = Integer.MAX_VALUE;
        int origin = 0, dest = 1;
        for(int i = 1; i<n-1; i++) {
            while(dest < n) {
                if(dest == i) {
                    dest++;
                    continue;
                }
                cnt += (Math.abs(x[origin] - x[dest]) + Math.abs(y[origin] - y[dest]));
                origin = dest;
                dest++;
            }
            minNum = Math.min(minNum, cnt);
        }

        System.out.print(minNum);
    }
}