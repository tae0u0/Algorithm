import java.io.*;
import java.util.*;

public class Main {
    static int N, M, R;
    static List<Integer>[] edges;
    static boolean[] visited;
    static int[] sequence;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        edges = new ArrayList[N+1];
        visited = new boolean[N+1];
        sequence = new int[N+1];
        for(int i = 0; i<= N; i++) {
            edges[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < M; i++) {
            String[] edge = br.readLine().split(" ");
            int first = Integer.parseInt(edge[0]);
            int second = Integer.parseInt(edge[1]);
            edges[first].add(second);
            edges[second].add(first);
        }

        for(int i = 1; i<= N; i++) {
            Collections.sort(edges[i], Collections.reverseOrder());
        }
        dfs();

        for(int i = 1; i<= N; i++) {
            bw.write(sequence[i] + "\n");
        }
        bw.flush();
        bw.close();
    }

    private static void dfs() {
        Stack<Integer> st = new Stack<>();
        st.push(R);

        int cnt = 1;
        while(!st.empty()) {
            int node = st.pop();
            if(visited[node]) continue;
            visited[node] = true;
            sequence[node] = cnt++;
            for(int next : edges[node]) {
                if(!visited[next]) st.push(next);
            }
        }
    }
}