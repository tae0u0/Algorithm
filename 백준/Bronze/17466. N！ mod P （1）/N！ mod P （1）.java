import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        long rst = 1;

        for (int i = N; i > 0; i--) {
            rst *= i;
            rst %= P;
        }
        System.out.println(rst % P);
    }
}