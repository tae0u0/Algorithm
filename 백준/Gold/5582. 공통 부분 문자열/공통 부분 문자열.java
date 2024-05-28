import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String first = br.readLine();
        String second = br.readLine();

        int firstLen = first.length();
        int secondLen = second.length();

        int[][] matric = new int[firstLen + 1][secondLen + 1];
        int max = 0;

        for (int i = 1; i <= firstLen; i++) {
            for (int k = 1; k <= secondLen; k++) {
                if (first.charAt(i - 1) == second.charAt(k - 1)) {
                    matric[i][k] = matric[i - 1][k - 1] + 1;
                    max = Math.max(matric[i][k], max);
                }
                // 문자가 같지 않다면 공통 문자열 길이 끊김
                else
                    matric[i][k] = 0;
            }
        }
        bw.write(max + "\n");
        bw.flush();
        bw.close();
    }
}