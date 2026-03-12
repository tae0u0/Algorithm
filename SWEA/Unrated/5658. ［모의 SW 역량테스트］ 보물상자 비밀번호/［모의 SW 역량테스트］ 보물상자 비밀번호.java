import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Solution {
    private static int T, N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            int side = N / 4;
            String num = br.readLine();
            Set<Integer> set = new HashSet<>();
            for (int depth = 0; depth < side; depth++) {
                for (int i = 0; i < 4; i++) {
                    String str = num.substring(i * side, (i + 1) * side);
                    set.add(Integer.parseInt(str, 16));
                }
                String substring = num.substring(0, N - 1);
                num = num.charAt(N - 1) + substring;

            }
            List<Integer> list = set.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
            int rst = list.get(K - 1);
            sb.append("#").append(tc).append(" ").append(rst).append("\n");
        }

        System.out.println(sb.toString());
    }
}