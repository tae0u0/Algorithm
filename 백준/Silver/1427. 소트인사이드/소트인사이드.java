import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] charArray = br.readLine().toCharArray();
        int[] arr = new int[charArray.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = charArray[i] - '0';
        }

        int max, max_index;
        for (int i = 0; i < arr.length; i++) {
            max = arr[i];
            max_index = i;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[j] > max){
                    max = arr[j];
                    max_index = j;
                }
            }
            int temp = arr[i];
            arr[i] = max;
            arr[max_index] = temp;
        }
        for (int i = 0; i < arr.length; i++) {
            bw.write(arr[i]+"");
        }
        bw.flush();
        bw.close();
    }
}