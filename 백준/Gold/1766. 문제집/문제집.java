import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] cnt;
    static List<Integer>[] workbook;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        cnt = new int[N + 1];
        workbook = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            workbook[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            workbook[a].add(b);
            cnt[b]++;
        }

        Queue<Integer> q = new PriorityQueue<>();
        for (int i = 1; i <= N; i++) {
            if(cnt[i] == 0) q.add(i);
        }

        while(!q.isEmpty()) {
            int cur = q.poll();
            sb.append(cur).append(" ");

            for(int next : workbook[cur]) {
                cnt[next]--;
                if(cnt[next] == 0) q.add(next);
            }
        }

        System.out.println(sb.toString());
    }
}