import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Node[] arr = new Node[n];
        for(int i = 0; i < n; i++){
            arr[i] = new Node(i, Integer.parseInt(br.readLine()));
        }
        Arrays.sort(arr);
        int max = 0;
        for(int i = 0; i < n; i++){
            int change_index = arr[i].index - i;
            if(max < change_index){
                max = change_index;
            }
        }
        bw.write(max+1 + "\n");
        bw.flush();
        bw.close();
    }
    static class Node implements Comparable<Node>{
        int index;
        int value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }
        @Override
        public int compareTo(Node o) {
            return this.value - o.value;
        }
    }
}