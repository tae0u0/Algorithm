import java.io.*;
import java.util.*;

public class Main {
    static int C, N;
    static ArrayList<Node> arr = new ArrayList<>();
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        C = Integer.parseInt(split[0]);
        N = Integer.parseInt(split[1]);
        dp = new int[1000000];

        while(N-- > 0){
            split = br.readLine().split(" ");
            int cost = Integer.parseInt(split[0]);
            int value = Integer.parseInt(split[1]);
            arr.add(new Node(cost, value));
        }

        int answer = dp();
        System.out.println(answer);

    }

    private static int dp() {
        int i = 1;
        for (; i <= dp.length; i++) {
            for(Node node : arr){
                if(node.cost > i) continue;
                dp[i] = Math.max(node.value + dp[i - node.cost], dp[i]);
            }
            if(dp[i] >= C) break;
        }
        return i;
    }

    private static class Node {
        int cost, value;

        public Node(int cost, int value) {
            this.cost = cost;
            this.value = value;
        }
    }
}
