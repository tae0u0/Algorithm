import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String binary = sc.next();
        // Please write your code here.
        int num = 0;
        char[] arr = binary.toCharArray();
        for(int i = 0; i <arr.length; i++){
            num = num * 2 + Character.getNumericValue(arr[i]);
        }

        num *= 17;

        int[] digits = new int[20];
        int cnt = 0;
        while(num > 1){
            digits[cnt++] = num % 2;
            num /= 2;
        }
        digits[cnt] = num;

        for(;cnt >= 0; cnt--){
            System.out.print(digits[cnt]);
        }
    }
}