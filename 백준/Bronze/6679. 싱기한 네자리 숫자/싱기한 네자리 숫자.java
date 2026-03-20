import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        for (int n = 1000; n <= 9999; n++) {
            int sum10 = digitSum(Integer.toString(n, 10));
            int sum12 = digitSum(Integer.toString(n, 12));
            int sum16 = digitSum(Integer.toString(n, 16));

            if (sum10 == sum12 && sum12 == sum16) {
                sb.append(n).append('\n');
            }
        }

        System.out.print(sb);
    }

    static int digitSum(String s) {
        int sum = 0;
        for (char c : s.toCharArray()) {
            sum += Character.digit(c, 16);
        }
        return sum;
    }
}