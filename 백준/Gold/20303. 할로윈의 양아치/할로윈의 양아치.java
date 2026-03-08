import java.io.*;
import java.util.*;

public class Main {
    private static int N, M, K;
    private static int[] candy;
    private static List<Integer>[] adjacent;
    private static boolean[] visited;
    private static List<Group> groups;

    static class Group {
        int size;
        int cost;

        public Group(int size, int cost) {
            this.size = size;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        init();

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                groups.add(bfs(i));
            }
        }

        int[] dp = new int[K];

        for (Group g : groups) {
            for (int i = K - 1; i >= g.size; i--) {
                dp[i] = Math.max(dp[i], dp[i - g.size] + g.cost);
            }
        }

        int result = 0;
        for (int i = 0; i < K; i++) {
            result = Math.max(result, dp[i]);
        }
        System.out.println(result);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        candy = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            candy[i] = Integer.parseInt(st.nextToken());
        }

        adjacent = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            adjacent[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjacent[a].add(b);
            adjacent[b].add(a);
        }

        visited = new boolean[N + 1];
        groups = new ArrayList<>();
    }

    private static Group bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        int totalCandy = 0;
        int totalCount = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();
            totalCandy += candy[cur];
            totalCount++;

            for (int next : adjacent[cur]) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                }
            }
        }
        return new Group(totalCount, totalCandy);
    }
}