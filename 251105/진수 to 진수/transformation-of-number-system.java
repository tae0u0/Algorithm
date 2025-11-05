import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        String N = sc.next();
        // Please write your code here.
        char[] digits = N.toCharArray();
        int num = 0;

        for(int i = 0; i<digits.length; i++) {
            num = num * A + Character.getNumericValue(digits[i]);
        }

        int[] arr = new int[20];
        int cnt = 0;
        while(num > B-1){
            arr[cnt++] = num % B;
            num /= B;
        }
        arr[cnt] = num;

        for(; cnt >= 0; cnt--){
            System.out.print(arr[cnt]);
        }
    }
}