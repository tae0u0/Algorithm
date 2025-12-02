import java.util.*;

public class Main {
    static int N;
    static List<Node> arr = new ArrayList<>();
    static class Node implements Comparable<Node> {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Node o) {
            if (this.x == o.x) {
                return Integer.compare(this.y, o.y);
            }
            return Integer.compare(this.x, o.x);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            arr.add(new Node(sc.nextInt(), sc.nextInt()));
        }

        Collections.sort(arr);
        StringBuilder sb = new StringBuilder();
        for (Node o : arr) {
            sb.append(o.x).append(" ").append(o.y).append("\n");
        }
        System.out.println(sb);
    }
}