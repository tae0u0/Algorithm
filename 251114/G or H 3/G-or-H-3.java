import java.util.Scanner;
import java.util.Arrays;
import java.lang.Math;

public class Main {
    static class Node implements Comparable<Node> {
        int pos;
        char c;

        public Node(int pos, char c) {
            this.pos = pos;
            this.c = c;
        }

        @Override
        public int compareTo(Node o) {
            return this.pos - o.pos;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        Node[] arr = new Node[n];
        for (int i = 0; i < n; i++) {
            int pos = sc.nextInt();
            char c = sc.next().charAt(0);
            arr[i] = new Node(pos, c);
        }
        
        Arrays.sort(arr);
        int maxNum = Integer.MIN_VALUE;
        for(int i = 0; i<n; i++) {
            int cnt = arr[i].c == 'G' ? 1 : 2;
            for(int j = i + 1; j < n; j++) {
                if(arr[j].pos - arr[i].pos <= k) {
                    cnt += arr[j].c == 'G' ? 1 : 2;
                } else break;
            }
            maxNum = Math.max(maxNum, cnt);
        }

        System.out.print(maxNum);
    }
}