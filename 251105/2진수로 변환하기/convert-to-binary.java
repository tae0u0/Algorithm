import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.
        int[] digits = new int[20];
        int cnt = 0;

        while(n >= 2){
            digits[cnt++] = n % 2;
            n /= 2;
        }
        digits[cnt] = n % 2;

        for(; cnt >= 0; cnt--){
            System.out.print(digits[cnt]);
        }
    }
}