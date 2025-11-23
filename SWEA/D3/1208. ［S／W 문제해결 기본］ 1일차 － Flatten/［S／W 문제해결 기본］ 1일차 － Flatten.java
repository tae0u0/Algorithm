import java.io.*;
import java.util.*;

public class Solution {
    static int[] arr;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int testCase = 1; testCase <= 10; testCase++) {
            N = Integer.parseInt(br.readLine());
            arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Arrays.sort(arr);
            int rst = tp();
            bw.write("#" + testCase + " " + rst + "\n");
        }
        bw.flush();
        bw.close();
    }

    private static int tp() {
        int left = 0;
        int right = arr.length - 1;
        while (N-- > 0) {
            arr[left]++;
            arr[right]--;
            if (arr[left] > arr[left + 1]) {
                int swapPoint = left;
                while (arr[swapPoint] >= arr[swapPoint + 1]) {
                    swapPoint++;
                }
                swap(0, swapPoint);
            }

            if (arr[right] < arr[right - 1]) {
                int swapPoint = right;
                while (arr[swapPoint] <= arr[swapPoint - 1]) {
                    swapPoint--;
                }
                swap(arr.length - 1, swapPoint);
            }
        }

        return arr[arr.length-1] - arr[0];
    }

    private static void swap(int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
