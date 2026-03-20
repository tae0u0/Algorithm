import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int index, height;

        public Node(int index, int height) {
            this.index = index;
            this.height = height;
        }


        @Override
        public int compareTo(Node o) {
            return this.index - o.index;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Node[] arr = new Node[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            arr[i] = new Node(index, height);
        }
        Arrays.sort(arr);

        int maxIndex = -1;
        int maxHeight = -1;
        for (int i = 0; i < N; i++) {
            if(maxHeight < arr[i].height) {
                maxIndex = i;
                maxHeight = arr[i].height;
            }
        }

        int sum = arr[maxIndex].height;

        Node maxNode = new Node(arr[0].index, arr[0].height);
        for (int i = 1; i <= maxIndex; i++) {
            if(maxNode.height <= arr[i].height) {
                sum += maxNode.height * (arr[i].index - maxNode.index);
                maxNode.index = arr[i].index;
                maxNode.height = arr[i].height;
            }
        }

        maxNode = new Node(arr[N-1].index, arr[N-1].height);
        for (int i = N-2; i >= maxIndex; i--) {
            if(maxNode.height <= arr[i].height) {
                sum += maxNode.height * (maxNode.index- arr[i].index);
                maxNode.index = arr[i].index;
                maxNode.height = arr[i].height;
            }
        }

        System.out.println(sum);
    }
}