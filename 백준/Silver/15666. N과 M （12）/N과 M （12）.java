import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr, rst;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Arrays.sort(arr);
        rst = new int[M];

        dfs(0, 0);

        bw.flush();
        bw.close();
    }

    private static void dfs(int start, int depth) throws IOException {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                bw.write(rst[i] + " ");
            }
            bw.write("\n");
            return;
        }

        int prev = -1;
        for (int i = start; i < N; i++) {
            if (prev == arr[i]) continue;
            prev = arr[i];

            rst[depth] = arr[i];
            dfs(i, depth + 1);
        }
    }
}
