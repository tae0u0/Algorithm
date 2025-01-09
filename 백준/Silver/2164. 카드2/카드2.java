import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        Queue queue = new LinkedList();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }
        while(queue.size() != 1) {
            queue.remove();
            queue.add(queue.poll());
        }
        bw.write(queue.poll().toString());
        bw.flush();
        bw.close();
    }
}