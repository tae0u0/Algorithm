import java.util.Scanner;
import java.lang.Math;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] a = new int[n][2];
        int[][] b = new int[m][2];
        int[] distanceA = new int[1_000_001];
        int[] distanceB = new int[1_000_001];

        int timeA = 1;
        for (int i = 0; i < n; i++) {
            a[i][0] = sc.nextInt(); // v
            a[i][1] = sc.nextInt(); // t
            for(int k = 0; k<a[i][1]; k++){
                distanceA[timeA++] = distanceA[timeA-1] + a[i][0];
            }
        }

        int timeB = 1;
        for (int i = 0; i < m; i++) {
            b[i][0] = sc.nextInt();
            b[i][1] = sc.nextInt();
              for(int k = 0; k<b[i][1]; k++){
                distanceB[timeB++] = distanceB[timeB-1] + b[i][0];
            }
        }

        boolean[] head = new boolean[2]; // A는 0 B는 1
        int time = Math.max(timeA, timeB);
        int cnt = 0;
        for(int i = 1; i<=time; i++){
            if (distanceA[i] > distanceB[i]){
                if(head[1] == true) cnt++;
                head[0] = true;
                head[1] = false;
            } else if (distanceB[i] > distanceA[i]){
                if(head[0] == true) cnt++;
                head[0] = false;
                head[1] = true;
            } else {
                if(head[0] == false || head[1] == false) cnt++;
                head[0] = true;
                head[1] = true;
            }
        }

        System.out.print(cnt);

    }
}