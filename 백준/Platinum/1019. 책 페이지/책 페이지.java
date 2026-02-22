import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());

        long[] count = new long[10];

        for (long digit = 1; digit <= N; digit *= 10) {

            long high = N / (digit * 10);
            long cur  = (N / digit) % 10;
            long low  = N % digit;

            for (int d = 1; d <= 9; d++) {
                count[d] += high * digit;

                if (cur > d) {
                    count[d] += digit;
                } else if (cur == d) {
                    count[d] += low + 1;
                }
            }

            if (high > 0) {
                count[0] += (high - 1) * digit;

                if (cur > 0) {
                    count[0] += digit;
                } else if (cur == 0) {
                    count[0] += low + 1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(count[i]).append(" ");
        }
        System.out.println(sb);
    }
}