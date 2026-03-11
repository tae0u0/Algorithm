import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] line = br.readLine().toCharArray();

        for (int i = 0; i < (N - 1) / 2 + 1; i++) {
            if(line[i] == '?' && line[N-i-1] == '?') {
                line[i] = 'a';
                line[N - 1 - i] = 'a';
            }

            else if(line[i] == '?') {
                line[i] = line[N - 1 - i];
            } else if (line[N-1-i] == '?') {
                line[N - 1 - i] = line[i];
            }
        }
        System.out.println(String.valueOf(line));
    }
}