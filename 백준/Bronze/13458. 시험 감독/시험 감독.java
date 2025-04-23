import java.io.*;
import java.util.*;

public class Main {
    static int N, B, C;
    static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        long result = 0;
        for (int i = 0; i < N; i++) {
            result += solve(i);
        }

        System.out.println(result);
    }

    static long solve(int i) {
        long count = 1;
        int remaining = A[i] - B;
        if (remaining > 0) {
            count += (remaining + C - 1) / C;
        }
        return count;
    }
}
