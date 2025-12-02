import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] card;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        card = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : card) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        M = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (map.containsKey(num)) {
                bw.write(map.get(num) + " ");
            } else {
                bw.write("0 ");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
