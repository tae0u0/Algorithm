import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static int[] arr;
    private static int[] index;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        index = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> li = new ArrayList<>();
        li.add(arr[0]);
        index[0] = 0;

        for (int i = 1; i < N; i++) {
            if(li.get(li.size()-1) < arr[i]) {
                li.add(arr[i]);
                index[i] = li.size() - 1;
            }
            else {
                int left = 0;
                int right = li.size() - 1;
                int key = arr[i];
                while(left < right) {
                    int mid = (left + right) / 2;
                    if(li.get(mid) < key) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }

                li.set(right, key);
                index[i] = right;
            }
        }

        Deque<Integer> deq = new ArrayDeque<>();
        int liSize = li.size();
        StringBuilder sb = new StringBuilder();
        sb.append(li.size()).append("\n");

        for (int i = N-1; i >= 0; i--) {
            if(index[i] == liSize - 1) {
                deq.add(arr[i]);
                liSize--;
            }
        }

        while(!deq.isEmpty()) {
            int num = deq.pollLast();
            sb.append(num).append(" ");
        }
        System.out.println(sb.toString());
    }
}