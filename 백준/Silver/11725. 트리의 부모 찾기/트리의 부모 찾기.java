import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] parent;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i <= N ; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            graph.get(first).add(second);
            graph.get(second).add(first);
        }

        Stack<Integer> st = new Stack<>();
        st.push(1);
        parent = new int[N + 1];
        visited = new boolean[N + 1];
        while(!st.isEmpty()){
            int num = st.pop();
            visited[num] = true;

            for (int child : graph.get(num)) {
                if(!visited[child]){
                    parent[child] = num;
                    st.push(child);
                }
            }
        }

        for (int i = 2; i <= N ; i++) {
            System.out.println(parent[i]);
        }
    }
}