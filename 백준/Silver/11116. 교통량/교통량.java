import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer leftSt = new StringTokenizer(br.readLine());
            List<Integer> leftList = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                leftList.add(Integer.parseInt(leftSt.nextToken()));
            }

            StringTokenizer rightSt = new StringTokenizer(br.readLine());
            List<Integer> rightList = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                rightList.add(Integer.parseInt(rightSt.nextToken()));
            }

            int cnt = 0;
            for (int num : leftList) {
                if (rightList.contains(num + 1000)) {
                    cnt++;
                }
            }
            System.out.println(cnt / 2);
        }

    }
}