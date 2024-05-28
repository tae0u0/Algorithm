import java.io.*;
import java.util.Arrays;
import java.util.Stack;

public class Main {
    static int[][] matric;

    static void Solution() {

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String first = br.readLine();
        String second = br.readLine();

        int firstLen = first.length();
        int secondLen = second.length();

        matric = new int[firstLen + 1][secondLen + 1];

        for (int i = 1; i <= firstLen; i++) {
            for (int k = 1; k <= secondLen; k++) {
                if (first.charAt(i-1) == second.charAt(k-1)) {
                    matric[i][k] = matric[i - 1][k - 1] + 1;
                } else
                    matric[i][k] = Math.max(matric[i - 1][k], matric[i][k - 1]);
            }
        }
        Stack<Character> rst = new Stack<>();
        int y = firstLen;
        int x = secondLen;
        while (matric[y][x] != 0){
            if(matric[y][x] == matric[y-1][x])
                y--;
            else if(matric[y][x] == matric[y][x-1])
                x--;
            else{
                y--;
                x--;
                rst.add(first.charAt(y));
            }
        }

        bw.write(matric[firstLen][secondLen]+"\n");
        for (int i = rst.size(); i > 0; i--) {
            bw.write(rst.pop());
        }
        bw.write("\n");
        bw.flush();
        bw.close();

    }
}