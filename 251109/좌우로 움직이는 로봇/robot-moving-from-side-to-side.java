import java.util.Scanner;
import java.util.Arrays;
import java.lang.Math;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] posA = new int[1_000_001];
        int[] posB = new int[1_000_001];
        int timeA = 0;
        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();
            char d = sc.next().charAt(0);
            // Please write your code here.
            if(d == 'R'){
                while(t-- > 0){
                    timeA++;
                    posA[timeA] = posA[timeA-1] + 1;
                }
            } else {
                while(t-- > 0){
                    timeA++;
                    posA[timeA] = posA[timeA-1] - 1;
                }
            }
        }
        Arrays.fill(posA, timeA+1, 1_000_000, posA[timeA]);
        
        int timeB = 0;
        for (int i = 0; i < m; i++) {
            int t = sc.nextInt();
            char d = sc.next().charAt(0);
            // Please write your code here.
             if(d == 'R'){
                while(t-- > 0){
                    timeB++;
                    posB[timeB] = posB[timeB-1] + 1;
                }
            } else {
                while(t-- > 0){
                    timeB++;
                    posB[timeB] = posB[timeB-1] - 1;
                }
            }
        }
        Arrays.fill(posB, timeB+1, 1_000_000, posB[timeB]);
        
        // Please write your code here.
        int time = Math.max(timeA, timeB);
        int cnt = 0;
        for(int i = 1; i<=time; i++) {
            if(posA[i] == posB[i] && posA[i-1] != posB[i-1]) {
                cnt++;
            }
        }
        System.out.print(cnt);
    }
}