import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Arrays.sort(arr);

        int left = 0;
        int right = arr[N - 1];

        while (left < right) {
            int middle = (left + right) / 2;

            if (log(middle)) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }

        System.out.println(left - 1);
    }

    private static boolean log(int height) {
        long sum = 0;

        for (int i = 0; i < N; i++) {
            if (arr[i] > height)
                sum += arr[i] - height;
        }

        return sum >= M;
    }
}