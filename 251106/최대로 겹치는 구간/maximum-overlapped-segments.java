import java.util.Scanner;
import java.lang.Math;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x1 = new int[n];
        int[] x2 = new int[n];
        for (int i = 0; i < n; i++) {
            x1[i] = sc.nextInt() + 100;
            x2[i] = sc.nextInt() + 100;
        }
        // Please write your code here.
        int[] index = new int[201];
        for(int i = 0; i < n; i++){
            for(int k = x1[i]; k < x2[i]; k++){
                index[k]++;
            }
        }

        int max_num = 0;
        for(int i = 0; i<= 200; i++){
            max_num = Math.max(index[i], max_num);
        }
        System.out.print(max_num);
    }
}