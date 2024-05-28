import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int total = Integer.parseInt(br.readLine().trim());
        int num = Integer.parseInt(br.readLine().trim());
        int rst = 0;
        for(int i =0; i<num; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int price = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());
            rst += price * count;
        }
        if(total == rst)
            bw.write("Yes\n");
        else
            bw.write("No\n");
        bw.flush();
        bw.close();
    }
}