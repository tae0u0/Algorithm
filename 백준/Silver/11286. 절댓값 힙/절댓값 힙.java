import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        Queue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            int first_abs = Math.abs(o1);
            int second_abs = Math.abs(o2);
            if(first_abs == second_abs)
                return o1 > o2 ? 1 : -1;
            else
                return first_abs - second_abs;
        });

        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(br.readLine());
            if(num != 0){
                pq.add(num);
            }
            else {
                if(pq.isEmpty()){
                    bw.write("0\n");
                }else {
                    bw.write(pq.poll() + "\n");
                }
            }
        }
        bw.flush();
        bw.close();
    }
}