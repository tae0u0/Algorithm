import java.io.*;
import java.util.*;

public class Main {
    private static Map<String, Set<String>> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            map = new HashMap<>();
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String cloth = st.nextToken();
                String type = st.nextToken();
                map.computeIfAbsent(type, k -> new HashSet<>()).add(cloth);
            }

            int rst = 1;
            for(Set<String> set : map.values()) {
                rst *= set.size() + 1;
            }
            System.out.println(rst - 1);
        }
    }
}