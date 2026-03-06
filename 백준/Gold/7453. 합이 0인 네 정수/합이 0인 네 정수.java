import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] A, B, C, D;

    public static void main(String[] args) throws IOException {
        init();

        int[] sumAB = new int[N * N];
        int[] sumCD = new int[N * N];
        int idx = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sumAB[idx] = A[i] + B[j];
                sumCD[idx] = C[i] + D[j];
                idx++;
            }
        }

        Arrays.sort(sumAB);
        Arrays.sort(sumCD);

        System.out.println(countZeroPairs(sumAB, sumCD));
    }

    private static long countZeroPairs(int[] ab, int[] cd) {
        int left = 0;
        int right = cd.length - 1;
        long totalCount = 0;

        while (left < ab.length && right >= 0) {
            int currentSum = ab[left] + cd[right];

            if (currentSum == 0) {
                long leftTarget = ab[left];
                long leftCount = 0;
                while (left < ab.length && ab[left] == leftTarget) {
                    leftCount++;
                    left++;
                }

                long rightTarget = cd[right];
                long rightCount = 0;
                while (right >= 0 && cd[right] == rightTarget) {
                    rightCount++;
                    right--;
                }

                totalCount += (leftCount * rightCount);
            } else if (currentSum < 0) {
                left++;
            } else {
                right--;
            }
        }
        return totalCount;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        if (input == null) return;

        N = Integer.parseInt(input);
        A = new int[N];
        B = new int[N];
        C = new int[N];
        D = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            D[i] = Integer.parseInt(st.nextToken());
        }
    }
}