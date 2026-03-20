import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = N - 1; i >= 0; i--) {
            for (int j = i; j > 0; j--) {
                sb.append(' ');
            }
            for (int j = N - i; j > 0; j--) {
                sb.append('*');
            }
            sb.append('\n');
        }

        for (int i = N - 1; i >= 0; i--) {
            for (int j = N - i; j > 0; j--) {
                sb.append(' ');
            }
            for (int j = i; j > 0; j--) {
                sb.append('*');
            }
            sb.append('\n');
        }
        System.out.println(sb.toString());
    }
}