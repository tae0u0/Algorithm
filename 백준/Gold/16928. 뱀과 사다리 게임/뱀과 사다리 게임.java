import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static Map<Integer, Integer> ladder = new HashMap<>();
    static Map<Integer, Integer> snake = new HashMap<>();
    static int[] map = new int[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            ladder.put(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
        }

        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            snake.put(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
        }

        int answer = solve();
        System.out.println(answer);
    }

    private static int solve(){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(1, 0));
        int answer = Integer.MAX_VALUE;
        Arrays.fill(map, Integer.MAX_VALUE);

        while(!q.isEmpty()){
            Node cur = q.poll();

            if(cur.dest == 100){
                answer = Integer.min(answer, cur.count);
            }

            for (int i = 1; i <= 6 ; i++) {
                int next = cur.dest + i;
                int nextCount = cur.count + 1;
                if(ladder.containsKey(next)){
                    next = ladder.get(next);
                }

                if(snake.containsKey(next)){
                    next = snake.get(next);
                }
                
                if(next <= 100 && map[next] > nextCount){

                    map[next] = nextCount;
                    q.add(new Node(next, nextCount));
                }
            }
        }

        return answer;
    }

    private static class Node {
        int dest, count;

        public Node(int dest, int count) {
            this.dest = dest;
            this.count = count;
        }
    }
}