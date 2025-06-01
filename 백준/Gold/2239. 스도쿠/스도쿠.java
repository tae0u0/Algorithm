import java.io.*;
import java.util.*;

public class Main {
    static int[][] map = new int[9][9];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < 9; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(split[j]);
            }
        }

        back(0, 0);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                bw.write(map[i][j] +"");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    static private boolean back(int row, int col) {
        if(col == 9) return back(row + 1, 0);
        if(row == 9) return true;
        if(map[row][col] != 0) return back(row, col + 1);

        for (int k = 1; k <= 9; k++) {
            if(valid(row, col, k)) {
                map[row][col] = k;
                if(back(row, col + 1)) return true;
                map[row][col] = 0;
            }
        }
        
        return false;
    }

    private static boolean valid(int row, int col, int value) {
        for (int i = 0; i < 9; i++) {
            if(map[row][i] == value) return false;
        }

        for (int i = 0; i < 9; i++) {
            if(map[i][col] == value) return false;
        }

        int rowStart = (row/3) * 3;
        int colStart = (col/3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(map[rowStart + i][colStart + j] == value) return false;
            }
        }

        return true;
    }
}