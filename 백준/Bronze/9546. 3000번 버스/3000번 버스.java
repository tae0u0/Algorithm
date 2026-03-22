import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int num = Integer.parseInt(br.readLine());
            Double sum = 0.0;
            for (int j = 0; j < num; j++) {
                sum += 0.5;
                sum *= 2;
            }
            System.out.println(sum.intValue());
        }
    }
}