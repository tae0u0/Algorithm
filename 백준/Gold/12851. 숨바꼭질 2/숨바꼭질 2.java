import java.util.*;

public class Main {
    static int MAX = 100000;
    static int[] dist = new int[MAX + 1];
    static int[] ways = new int[MAX + 1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();

        Arrays.fill(dist, -1);

        Queue<Integer> q = new LinkedList<>();
        q.add(A);
        dist[A] = 0;
        ways[A] = 1;

        while (!q.isEmpty()) {
            int cur = q.poll();

            int[] nextPos = {cur - 1, cur + 1, cur * 2};

            for (int next : nextPos) {
                if (next < 0 || next > MAX) continue;

                if (dist[next] == -1) {
                    dist[next] = dist[cur] + 1;
                    ways[next] = ways[cur];
                    q.add(next);
                }
                else if (dist[next] == dist[cur] + 1) {
                    ways[next] += ways[cur];
                }
            }
        }

        System.out.println(dist[B]);
        System.out.println(ways[B]);
    }
}
