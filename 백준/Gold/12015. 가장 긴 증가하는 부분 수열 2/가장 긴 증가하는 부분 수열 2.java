import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        init();

        List<Integer> list = new ArrayList<>();
        list.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            if(list.get(list.size()-1) < key) list.add(key);
            else {
                int left = 0;
                int right = list.size() - 1;

                while(left < right) {
                    int mid = (left + right) / 2;
                    if(list.get(mid) < key) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                list.set(right, key);
            }
        }

        System.out.println(list.size());

    }

    private static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
}