import java.io.*;
import java.util.*;

public class Main {
    static int A, B, C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        int answer = merge(B);
        System.out.println(answer);
    }

    private static int merge(int repeat) {
        if(repeat == 1){
            return A % C;
        }

        long half = merge(repeat / 2) % C;
        long answer = (half * half) % C;
        if(repeat % 2 == 1)
            answer = (answer * A) % C;

        return (int) answer;
    }
}
