import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            String cmd = s[0];

            if (cmd.equals("push")) {
                q.add(Integer.parseInt(s[1]));
            } else if (cmd.equals("pop")){
                if(q.isEmpty()){
                    bw.write("-1\n");
                } else {
                    bw.write(q.poll() + "\n");
                }
            } else if (cmd.equals("size")) {
                bw.write(q.size() + "\n");
            } else if (cmd.equals("empty")) {
                if(q.isEmpty()){
                    bw.write("1\n");
                } else {
                    bw.write("0\n");
                }
            } else if (cmd.equals("front")){
                if(q.isEmpty()){
                    bw.write("-1\n");
                } else {
                    bw.write(q.peek() + "\n");
                }
            } else if(cmd.equals("back")){
                if(q.isEmpty()){
                    bw.write("-1\n");
                } else {
                    bw.write(q.toArray()[q.size()-1] + "\n");
                }
            }
        }
        bw.flush();
        bw.close();
    }
}