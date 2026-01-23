import java.io.*;
import java.util.*;

public class Main {
    static Integer[][] arr;
    static int[][] rst;
    static List<int[]> blank = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        arr = new Integer[9][9];

        for (int row = 0; row < 9; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col < 9; col++) {
                int num = Integer.parseInt(st.nextToken());
                if(num == 0) blank.add(new int[]{row, col});
                arr[row][col] = num;
            }
        }

        recur(0);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                bw.write(arr[i][j] + " ");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }

    private static boolean recur(int index) {
        if (blank.size() == index) {
            return true;
        }

        int[] pos = blank.get(index);
        int curY = pos[0];
        int curX = pos[1];

        List<Integer> integers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));

        for (int i = 0; i < 9; i++) {
            integers.remove(arr[curY][i]);
            integers.remove(arr[i][curX]);
        }
        int startY = (curY / 3) * 3;
        int startX = (curX / 3) * 3;
        for (int i = startY; i < startY + 3; i++) {
            for (int j = startX; j < startX + 3; j++) {
                integers.remove(arr[i][j]);
            }
        }

        if(integers.isEmpty()) return false;

        for (int num : integers) {
            arr[curY][curX] = num;
            if(recur(index+1)) return true;
            arr[curY][curX] = 0;
        }

        return false;
    }
}