import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String binary = sc.next();
        // Please write your code here.

        int num = 0;
        char[] arr = binary.toCharArray();
        for(int i = 0; i<arr.length; i++) {
            num = num * 2 + Character.getNumericValue(arr[i]);
        }

        System.out.print(num);
    }
}