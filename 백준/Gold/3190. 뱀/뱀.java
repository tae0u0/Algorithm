import java.util.*;

public class Main {
    static int N, K, L;
    static int[][] map, d_change;
    static int[][] dirs = {
            {0, -1}, {1, 0}, {0, 1}, {-1, 0}
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        map = new int[N][N];

        int row, col;
        for (int i = 0; i < K; i++) {
            row = sc.nextInt();
            col = sc.nextInt();
            map[row-1][col-1] = 1;
        }

        L = sc.nextInt();
        d_change = new int[L][2];
        for (int i = 0; i < L; i++) {
            d_change[i][0] = sc.nextInt();
            d_change[i][1] = getDirType(sc.next());
        }

        int rst = solve();
        System.out.println(rst);
    }

    static int solve(){
        Deque<Node> q = new ArrayDeque<>();
        q.add(new Node(0, 0));
        int direction = 1;
        int runtime = 0;
        int index = 0;
        while(true) {
            runtime++;
            Node head = q.getLast();
            Node next_node = new Node(head.y + dirs[direction][1], head.x + dirs[direction][0]);

            if (next_node.x < 0 || next_node.y < 0 || next_node.x >= N || next_node.y >= N || q.contains(next_node)) {
                return runtime;
            }

            q.add(next_node);
            if (map[next_node.y][next_node.x] == 1) {
                map[next_node.y][next_node.x] = 0;
            }  else {
                q.pollFirst();

            }

            if(index < L && runtime == d_change[index][0]) {
                direction = (direction + d_change[index][1] + 4) % 4;
                index++;
            }
        }
    }

    static int getDirType(String type) {
        if(type.equals("L")) {
            return -1;
        } else
            return 1;
    }

    static class Node {
        int y, x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }

        @Override
        public boolean equals(Object o) {
            Node node = (Node) o;
            return y == node.y && x == node.x;
        }

        @Override
        public int hashCode() {
            return Objects.hash(y, x);
        }
    }
}
