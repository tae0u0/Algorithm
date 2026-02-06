import java.io.*;
import java.util.*;

public class Solution {
    private static int N, M;
    private static List<int[]> mix = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            mix.clear();
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken()) - 1; // 0-based
                int b = Integer.parseInt(st.nextToken()) - 1;
                mix.add(new int[]{a, b});
            }

            // 공집합 + 원소 1개짜리 집합
            int answer = 1 + N;

            for (int mask = 0; mask < (1 << N); mask++) {
                if (Integer.bitCount(mask) < 2) continue;

                if (isAvailable(mask)) {
                    answer++;
                }
            }

            sb.append("#").append(testCase).append(" ").append(answer).append("\n");
        }

        System.out.print(sb.toString());
    }

    private static boolean isAvailable(int mask) {
        for (int[] arr : mix) {
            int a = arr[0];
            int b = arr[1];

            if ((mask & (1 << a)) != 0 && (mask & (1 << b)) != 0) {
                return false;
            }

            // 
        }
        return true;
    }
}
