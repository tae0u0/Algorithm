import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] parent, rank;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        parent = new int[N+1];
        for(int i = 0; i<=N; i++) {
            parent[i] = i;
        }
        rank = new int[N+1];

        for(int i = 0; i<M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if(command == 0) {
                union(x, y);
            } else {
                if(isCycle(x, y)) System.out.println("YES");
                else System.out.println("NO");
            }
        }

    }

    private static int find(int x) {
        if(parent[x] == x) return x;
        parent[x] = find(parent[x]);
        return parent[x];
    }

    private static void union(int x, int y) {
        int rx = find(x);
        int ry = find(y);

        if (rx == ry) return;

        if (rank[rx] < rank[ry]) {
            parent[rx] = ry;
        } else if (rank[rx] > rank[ry]) {
            parent[ry] = rx;
        } else {
            parent[ry] = rx;
            rank[rx]++;
        }
    }

    private static boolean isCycle(int x, int y) {
        return find(x) == find(y);
    }
}