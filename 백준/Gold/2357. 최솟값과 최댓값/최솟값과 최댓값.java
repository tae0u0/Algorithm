import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static Node[] tree;
    static int[] arr;

    static class Node {
        int min, max;
        Node(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        tree = new Node[4 * N];
        build(1, 0, N - 1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            Node result = query(1, 0, N - 1, a, b);
            sb.append(result.min).append(" ").append(result.max).append("\n");
        }

        System.out.print(sb);
    }

    static void build(int node, int start, int end) {
        if (start == end) {
            tree[node] = new Node(arr[start], arr[start]);
            return;
        }

        int mid = (start + end) / 2;
        build(node * 2, start, mid);
        build(node * 2 + 1, mid + 1, end);

        tree[node] = new Node(
                Math.min(tree[node * 2].min, tree[node * 2 + 1].min),
                Math.max(tree[node * 2].max, tree[node * 2 + 1].max)
        );
    }

    static Node query(int node, int start, int end, int left, int right) {
        if (right < start || end < left) {
            return new Node(Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        if (left <= start && end <= right) {
            return tree[node];
        }

        int mid = (start + end) / 2;
        Node l = query(node * 2, start, mid, left, right);
        Node r = query(node * 2 + 1, mid + 1, end, left, right);

        return new Node(
                Math.min(l.min, r.min),
                Math.max(l.max, r.max)
        );
    }
}
