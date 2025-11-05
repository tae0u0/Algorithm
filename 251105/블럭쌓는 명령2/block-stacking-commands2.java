import java.util.Scanner;
import java.lang.Math;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] arr = new int[N+1];
        for (int i = 0; i < K; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            for(int j = A; j <= B; j++){
                arr[j]++;
            }
        }

        int max_num = 0;
        for(int i = 1; i<N+1; i++){
            max_num = Math.max(max_num, arr[i]);
        }

        System.out.print(max_num);
    }
}