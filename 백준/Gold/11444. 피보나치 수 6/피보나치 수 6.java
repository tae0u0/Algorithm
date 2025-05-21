import java.io.*;

public class Main {
    static final long MOD = 1_000_000_007L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        System.out.println(fib(n)[0][1]);
    }

    
    public static long[][] fib(long n) {
        if (n == 1) {
            return new long[][] {
                    {1, 1},
                    {1, 0}
            };
        }

        long[][] half = fib(n / 2);
        long[][] result = multiply(half, half);

        if (n % 2 == 1) {
            long[][] base = {
                    {1, 1},
                    {1, 0}
            };
            result = multiply(result, base);
        }

        return result;
    }
    
    public static long[][] multiply(long[][] a, long[][] b) {
        long[][] result = new long[2][2];

        result[0][0] = (a[0][0] * b[0][0] % MOD + a[0][1] * b[1][0] % MOD) % MOD;
        result[0][1] = (a[0][0] * b[0][1] % MOD + a[0][1] * b[1][1] % MOD) % MOD;
        result[1][0] = (a[1][0] * b[0][0] % MOD + a[1][1] * b[1][0] % MOD) % MOD;
        result[1][1] = (a[1][0] * b[0][1] % MOD + a[1][1] * b[1][1] % MOD) % MOD;

        return result;
    }
}
