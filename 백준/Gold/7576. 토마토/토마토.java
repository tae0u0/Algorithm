import java.io.*;
import java.util.*;

public class Main {
    static int M, N;
    static int[][] map;
    static ArrayList<Node> ripeTomatoes = new ArrayList<>();
    static int[][] dirs = {
            {-1, 0}, {0, 1}, {1, 0}, {0, -1}
    };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N + 1][M + 1];

        boolean existUnripeTomato = false;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M ; j++) {
                int state = Integer.parseInt(st.nextToken());
                if(state == 0){
                    existUnripeTomato = true;
                } else if(state == 1){
                    ripeTomatoes.add(new Node(i, j, 0));
                }
                map[i][j] = state;
            }
        }

        if(!existUnripeTomato) {
            System.out.println(0);
            return;
        }

        int answer = solve();

        answer = allRipeTomato() ? answer : -1;
        System.out.println(answer);
    }

    private static int solve(){
        Queue<Node> q = new PriorityQueue<>();
        q.addAll(ripeTomatoes);
        boolean[][] visited = new boolean[N+1][M+1];
        for(Node node : ripeTomatoes){
            visited[node.y][node.x] = true;
        }

        int maxCount = 0;

        while(!q.isEmpty()){
            Node cur = q.poll();
            map[cur.y][cur.x] = 1;

            maxCount = Math.max(maxCount, cur.count);

            for (int i = 0; i < 4; i++) {
                int ny = cur.y + dirs[i][0];
                int nx = cur.x + dirs[i][1];

                if(ny > 0 && ny <= N && nx > 0 && nx <= M && !visited[ny][nx] && map[ny][nx] == 0) {
                    visited[ny][nx] = true;
                    q.add(new Node(ny, nx, cur.count + 1));
                }
            }
        }

        return maxCount;
    }

    private static boolean allRipeTomato(){
        for (int i = 1; i <= N ; i++) {
            for (int j = 1; j <= M ; j++) {
                if(map[i][j] == 0)
                    return false;
            }
        }
        return true;
    }

    private static class Node implements Comparable<Node> {
        int y, x, count;

        public Node(int y, int x, int count) {
            this.y = y;
            this.x = x;
            this.count = count;
        }

        @Override
        public int compareTo(Node o){
            return Integer.compare(this.count, o.count);
        }
    }
}