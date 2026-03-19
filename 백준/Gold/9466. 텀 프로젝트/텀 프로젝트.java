import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    static boolean[] visited;
    static boolean[] inCycle;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            arr     = new int[N + 1];
            visited = new boolean[N + 1];
            inCycle = new boolean[N + 1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= N; i++) {
                if (!visited[i]) findCycle(i);
            }

            int cnt = 0;
            for (int i = 1; i <= N; i++) {
                if (!inCycle[i]) cnt++;
            }
            sb.append(cnt).append('\n');
        }
        System.out.print(sb);
    }

    private static void findCycle(int start) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> stackIndex = new HashMap<>();

        int cur = start;
        while (true) {
            if (visited[cur]) {
                break;
            }
            if (stackIndex.containsKey(cur)) {
                int cycleStart = stackIndex.get(cur);
                for (int i = cycleStart; i < stack.size(); i++) {
                    inCycle[stack.get(i)] = true;
                }
                break;
            }
            stackIndex.put(cur, stack.size());
            stack.push(cur);
            cur = arr[cur];
        }

        for (int node : stack) {
            visited[node] = true;
        }
    }
}