import java.io.*;
import java.util.*;

public class Main {
    static int G, P;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        G = Integer.parseInt(br.readLine());
        P = Integer.parseInt(br.readLine());
        parent = new int[G + 1];
        for (int i = 1; i <= G; i++) {
            parent[i] = i;
        }

        int i;
        for (i = 1; i <= P; i++) {
            int num = Integer.parseInt(br.readLine());
            int parentNum = find(num);
            if(parentNum == num) {
                union(num, num - 1);
            } else if(parentNum == 0) {
                break;
            } else {
                union(parentNum, parentNum - 1);
            }
        }
        System.out.println(i - 1);
    }

    private static int find(int x) {
        if(x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    private static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if(pa == pb) return;
        parent[pa] = pb;
    }
}