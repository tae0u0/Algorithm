import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int max_num = 0;
        int cnt = 0;
        for(int i = 0; i<n; i++) {
            if(i == 0 || arr[i] == arr[i-1]) {
                cnt++;
                if(cnt > max_num) max_num = cnt;
            } else {
                cnt = 1;
            }
        }
        
        System.out.print(max_num);
    }
}