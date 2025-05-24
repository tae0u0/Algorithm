import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(s[0]);
            arr[i][1] = Integer.parseInt(s[1]);
        }

        double area = 0.0;
        for (int i = 0; i < N; i++) {
            area += ((long)arr[i][0] * arr[(i + 1) % N][1] - (long)arr[i][1] * arr[(i + 1) % N][0]);
        }
        area = Math.abs(area) / 2.0;

        System.out.printf("%.1f", area);
    }
}