import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Deque<Node> deque = new ArrayDeque<>();
        for(int i = 0; i < n; i++){
            int now =  Integer.parseInt(st.nextToken());
            while(!deque.isEmpty() && deque.peekLast().value > now){
                deque.pollLast();
            }
            deque.addLast(new Node(i, now));
            if(deque.peekFirst().index <= i - l){
                deque.pollFirst();
            }
            if(!deque.isEmpty()){
                bw.write(deque.peekFirst().value + " ");
            }
        }
        bw.flush();
        bw.close();
    }
    static class Node{
        int value;
        int index;
        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}