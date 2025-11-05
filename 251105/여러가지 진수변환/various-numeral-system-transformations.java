import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int b = sc.nextInt();
        // Please write your code here.
        int[] arr = new int[10];
        int num = 0, cnt = 0;
    
        while(n > b-1) {
            arr[cnt++] = n % b;
            n /= b;
        }
        arr[cnt] = n;

        for(; cnt >= 0; cnt--){
            System.out.print(arr[cnt]);
        }
    }
}