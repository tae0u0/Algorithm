import java.util.*;

public class Main {
    static final int MOD = 1_000_000_007;

    static long modPow(long base, long exp) {
        long result = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) result = result * base % MOD;
            base = base * base % MOD;
            exp >>= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int diceNum = sc.nextInt();

        long sum = 0;
        for (int i = 0; i < diceNum; i++) {
            long b = sc.nextInt(); // 분모
            long a = sc.nextInt(); // 분자

            long inverse = modPow(b, MOD - 2);
            sum = (sum + a * inverse) % MOD;
        }

        System.out.println(sum);
    }
}
