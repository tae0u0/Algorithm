import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        // Please write your code here.
        int rst = 0;
        for(int i = 1; i<= n; i++) {    // 구간 내 원소 개수
            for(int j = 0; j <= n - i; j++) {
                int cnt = 0;
                for(int k = j; k <j+i; k++) {
                    cnt += arr[k];
                } 
                double aver = (double)cnt / i; 
                for(int k = j; k < j+i; k++) {
                    if(aver == (double)arr[k]) {
                        rst++;
                        break;
                    }
                } 
            }
        }
        System.out.print(rst);
    }
}