import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static class Node {
        int x, y;

        public Node(int y, int x) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N][N];

        for(int i = 0; i < N; i++) {
            arr[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        int groupNum = 0;
        List<Integer> houseNum = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();

        for(int i = 0; i < N; i++) {
            for(int j = 0; j<N; j++) {
                if(arr[i][j] == 0 || visited[i][j]) continue;

                q.add(new Node(i, j));
                int cnt = 0;
                while(!q.isEmpty()) {
                    Node node = q.poll();
                    if(visited[node.y][node.x]) continue;
                    visited[node.y][node.x] = true;
                    cnt++;
                    for(int k = 0; k < 4; k++) {
                        int ny = node.y + dy[k];
                        int nx = node.x + dx[k];
                        if(isRange(ny, nx) && !visited[ny][nx] && arr[ny][nx] == 1) {
                            q.add(new Node(ny, nx));
                        }
                    }
                }
                houseNum.add(cnt);
                groupNum++;
            }
        }

        houseNum.sort(Comparator.comparingInt(o -> o));
        bw.write(groupNum + "\n");
        for(int num : houseNum){
            bw.write(num + "\n");
        }
        bw.flush();
        bw.close();
    }

    private static boolean isRange(int y, int x) {
        return y < N && y >= 0 && x < N && x >= 0;
    }
}