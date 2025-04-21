import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N, M, max = 0;
    static int[][] map, copy_map;
    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        map = new int[N][M];
        copy_map = new int[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        solve(0);
        System.out.println(max);
    }

    static void solve(int level) {
        if(level == 3){
            max = Math.max(max, count_virus());
            return;
        }

        for (int i = 0; i < N * M; i++) {
            int y = i / M;
            int x = i % M;
            if (map[y][x] == 0) {
                map[y][x] = 1;
                solve(level + 1);
                map[y][x] = 0;
            }
        }
    }

    static int count_virus(){
        copy();
        Queue<Node> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(copy_map[i][j] == 2){
                    Node start = new Node(i, j);
                    queue.add(start);
                }
            }
        }

        while(!queue.isEmpty()){
            Node cur = queue.poll();
            for (int k = 0; k < 4; k++) {
                int next_y = cur.y + dir[k][0];
                int next_x = cur.x + dir[k][1];
                if(next_y >=0 && next_x >= 0 && next_y < N && next_x < M && copy_map[next_y][next_x] == 0){
                    copy_map[next_y][next_x] = 2;
                    queue.add(new Node(next_y, next_x));
                }
            }
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(copy_map[i][j] == 0){
                    count++;
                }
            }
        }

        return count;
    }

    static void copy() {
        for (int i = 0; i < N; i++) {
            copy_map[i] = Arrays.copyOf(map[i], M);
        }
    }

    static class Node {
        int y, x;
        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}