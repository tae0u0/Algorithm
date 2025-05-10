import java.io.*;
import java.util.*;

public class Main {
    static int N, M, min = Integer.MAX_VALUE;
    static List<Node> houses, chickens, selected_chickens = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        houses = new ArrayList<>();
        chickens = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(input[j]);
                if(num == 1) {
                    houses.add(new Node(i, j));
                }
                else if(num == 2) {
                    chickens.add(new Node(i, j));
                }
            }
        }

        solve(0, 0);

        System.out.println(min);
    }

    static void solve(int count, int level) {
        if(count == M) {
            int sum = 0;
            for (Node house : houses) {
                int min_dist = Integer.MAX_VALUE;
                for (Node chicken : selected_chickens) {
                    int dist = Math.abs(house.x - chicken.x) + Math.abs(house.y - chicken.y);
                    min_dist = Math.min(min_dist, dist);
                }
                sum += min_dist;
            }

            min = Math.min(sum, min);
            return;
        }

        for (int i = level; i < chickens.size(); i++) {
            selected_chickens.add(chickens.get(i));
            solve(count+1, i+1);
            selected_chickens.remove(selected_chickens.size()-1);
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
