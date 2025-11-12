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

        int maxIndex = -1;
        int maxNum = Integer.MIN_VALUE;
        for(int i = 1; i < n-1; i++) {
            int dist = Math.abs(x[i] - x[i-1]) + Math.abs(y[i] - y[i-1]);
            if(maxNum < dist) {
                maxNum = dist;
                maxIndex = i;
            }
        }

        int origin = 0; int dest = 1;
        int cnt = 0;
        while(dest < n) {
            if(dest == maxIndex) {
                dest++;
                continue;
            }
            int dist = Math.abs(x[dest] - x[origin]) + Math.abs(y[dest] - y[origin]);
            cnt += dist;
            origin = dest;
            dest++;
        }

        System.out.print(cnt);
    }
}