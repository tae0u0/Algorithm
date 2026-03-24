import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = n; i >= 4; i--) {
            if (isGoldmin(i)) {
                System.out.println(i);
                break;
            }
        }
    }

    public static boolean isGoldmin(int num) {
        while (num > 0) {
            int digit = num % 10;
            if (digit != 4 && digit != 7) {
                return false;
            }
            num /= 10;
        }
        return true;
    }
}