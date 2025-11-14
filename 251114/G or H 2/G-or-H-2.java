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
        Node[] arr = new Node[n];
        for (int i = 0; i < n; i++) {
            int position = sc.nextInt();
            char ch = sc.next().charAt(0);
            arr[i] = new Node(position, ch);
        }

        Arrays.sort(arr);
        int maxNum = 0;
        for (int i = 2; i <= n; i += 2) {
            for (int j = 0; j < n - i; j++) {
                int gNum = 0;
                int hNum = 0;
                for(int k = j; k < j + i; k++) {
                    if(arr[k].c == 'G') gNum++;
                    else hNum++;
                }
                
                if(gNum == hNum) {
                    maxNum = Math.max(arr[j+i-1].pos - arr[j].pos, maxNum);
                }
            }
        }

        System.out.print(maxNum);
    }
}