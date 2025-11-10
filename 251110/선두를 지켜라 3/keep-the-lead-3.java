import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] a = new int[n][2];
        int[][] b = new int[m][2];

        int[] distA = new int[1_000_001];
        int[] distB = new int[1_000_001];

        int tA = 1; 
        for (int i = 0; i < n; i++) {
            a[i][0] = sc.nextInt(); // v
            a[i][1] = sc.nextInt(); // t
            for (int k = 0; k < a[i][1]; k++) {
                distA[tA] = distA[tA - 1] + a[i][0];
                tA++;
            }
        }
 
        int tB = 1;
        for (int i = 0; i < m; i++) {
            b[i][0] = sc.nextInt();
            b[i][1] = sc.nextInt(); 
            for (int k = 0; k < b[i][1]; k++) {
                distB[tB] = distB[tB - 1] + b[i][0];
                tB++;
            }
        }

      
        int last = Math.max(tA, tB);
        for (int i = tA + 1; i < last; i++) distA[i] = distA[tA];
        for (int i = tB + 1; i < last; i++) distB[i] = distB[tB];

        int prev = 0;
        int cnt = 0;
        for (int i = 1; i < last; i++) {
            int cur;
            if (distA[i] > distB[i]) cur = -1;
            else if (distB[i] > distA[i]) cur = 1;
            else cur = 0;

            if (cur != prev) {
                cnt++;
                prev = cur;
            }
        }

        System.out.println(cnt);
    }
}
