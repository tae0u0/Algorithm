import java.io.*;
import java.util.*;

public class Main {
    static int[][] direct = {
            {-1, 0}, {0, 1}, {1, 0}, {0, -1}
    };
    static int num, max, min;
    static Node[][] arr;
    static ArrayList<Node>[][] adjacent;

    static boolean init(){
        boolean ischanged = false;
        for(int i=1; i<=num; i++){
            for(int k=1; k<=num; k++){
                adjacent[i][k].clear();
                for(int dir = 0; dir < 4; dir++){
                    if (Movable(i, k, dir)) {
                        adjacent[i][k].add(arr[i+direct[dir][0]][k+direct[dir][1]]);
                        ischanged = true;
                    }
                }
            }
        }
        return ischanged;
    }
    static boolean Movable(int i, int k, int dir) {
        int next_y = i + direct[dir][0];
        int next_x = k + direct[dir][1];
        if(next_x > 0 && next_y > 0 && next_y <=num && next_x <= num) {
            int diff = Math.abs(arr[i][k].value - arr[next_y][next_x].value);
            if (diff >= min && diff <= max)
                return true;
        }
        return false;
    }
    static void Prim(){
        Queue<Node> queue = new LinkedList<>();
        ArrayList<Node> distribution = new ArrayList<>();
        boolean[][] visited = new boolean[num+1][num+1];

        for(int k = 1; k<=num; k++){
            for (int j = 1; j <= num; j++) {
                if (visited[k][j] != true) {
                    int count_val = 0;
                    int count_location = 0;
                    queue.add(arr[k][j]);
                    visited[k][j] = true;

                    while (!queue.isEmpty()) {
                        Node here = queue.poll();
                        distribution.add(here);
                        count_val += here.value;
                        count_location++;
                        for (int i = 0; i < adjacent[here.y][here.x].size(); i++) {
                            int next_y = adjacent[here.y][here.x].get(i).y;
                            int next_x = adjacent[here.y][here.x].get(i).x;
                            if (visited[next_y][next_x] != true) {
                                queue.add(arr[next_y][next_x]);
                                visited[next_y][next_x] = true;
                            }
                        }
                    }

                    count_val /= count_location;
                    for (Node node : distribution) {
                        arr[node.y][node.x].value = count_val;
                    }
                    distribution.clear();
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        num = Integer.parseInt(st.nextToken());
        min = Integer.parseInt(st.nextToken());
        max = Integer.parseInt(st.nextToken());
        arr = new Node[num + 1][num + 1];
        adjacent = new ArrayList[num + 1][num + 1];

        for(int i =1; i<=num; i++){
            String[] population = br.readLine().split(" ");
            for (int k = 1; k <= num; k++) {
                arr[i][k] = new Node(i, k, Integer.parseInt(population[k - 1]));
                adjacent[i][k] = new ArrayList<>();
            }
        }

        int rst = 0;
        while(true){
            if(!init())
                break;

            Prim();
            rst++;
        }

        bw.write(rst + "\n");
        bw.flush();
        bw.close();
    }
}

class Node {
    int y;
    int x;
    int value;

    public Node(int y, int x, int value) {
        this.y = y;
        this.x = x;
        this.value = value;
    }
}