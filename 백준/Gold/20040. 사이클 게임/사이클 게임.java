import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] parent;
    static int[] rank;

    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        parent = new int[N];
        rank = new int[N];
        for(int i = 0; i < N; i++) {
            parent[i] = i;
        }

        int rst = 0;
        for(int i = 0; i < M; i++) {
            String[] split = br.readLine().split(" ");
            int first = Integer.parseInt(split[0]);
            int second = Integer.parseInt(split[1]);
            if(isCycle(first, second)) {
                rst = i+1;
                break;
            }
            union(first, second);
        }
        System.out.println(rst);
    }

    private static int find(int x) {
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    private static void union(int x, int y) {
        int rx = find(x);
        int ry = find(y);

        if(rx == ry) return;

        if (rank[rx] < rank[ry]) parent[rx] = ry;
        else if (rank[rx] > rank[ry]) parent[ry] = rx;
        else {
            parent[ry] = rx;
            rank[rx]++;
        }
    }

    private static boolean isCycle(int x, int y) {
        return find(x) == find(y);
    }
}