import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        sb.append((1 << N) - 1).append("\n");
        recur(N, 1, 3, 2);
        System.out.println(sb.toString());
    }

    private static void recur(int n, int from, int to, int via) {
        if (n == 1) {
            sb.append(from).append(' ').append(to).append('\n');
            return;
        }
        recur(n - 1, from, via, to);
        sb.append(from).append(' ').append(to).append('\n');
        recur(n - 1, via, to, from);
    }
}