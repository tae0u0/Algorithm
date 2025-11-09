import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int a_cur = 0;
        int b_cur = 0;
        int[] A_pos = new int[1_000_001];
        int[] B_pos = new int[1_000_001];
        int[][] A = new int[n][2];
        for (int i = 0; i < n; i++) {
            A[i][0] = sc.nextInt();
            A[i][1] = sc.nextInt();
        }
        int[][] B = new int[m][2];
        for (int i = 0; i < m; i++) {
            B[i][0] = sc.nextInt();
            B[i][1] = sc.nextInt();
        }
        // Please write your code here.

        int time = 0;
        for(int i = 0; i<A.length; i++){
            for(int k = 0; k < A[i][1]; k++){
                time++;
                a_cur += A[i][0];
                A_pos[time] = a_cur;
            }
        }

        time = 0;
        for(int i = 0; i<B.length; i++){
            for(int k = 0; k < B[i][1]; k++){
                time++;
                b_cur += B[i][0];
                B_pos[time] = b_cur;
            }
        }

        int head = 0;
        int cnt = 0;

        for(int i = 2; i<time; i++){
            if(A_pos[i] > B_pos[i]) {
                if(head == 2) cnt++;
                head = 1;
            } else if(A_pos[i] < B_pos[i]){
                if(head == 1) cnt++;
                head = 2;
            }
        }
        System.out.print(cnt);

    }
}