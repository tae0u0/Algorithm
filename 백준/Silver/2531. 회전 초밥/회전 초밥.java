import java.io.*;
import java.util.*;

public class Main {
    static int N, d, k ,c; // 접시 수, 초밥 가짓수, 연속 접시 수, 쿠폰 번호(무료 초밥 번호)
    static int[] sushi;
    static Map<Integer, Integer> window = new HashMap<>();
    static int count = 0;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        sushi = new int[N];

        for (int i = 0; i < N; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            q.add(sushi[i]);
            if(!window.containsKey(sushi[i])) window.put(sushi[i], 1);
            else window.put(sushi[i], window.get(sushi[i])+1);
        }

        max = window.containsKey(c) ? window.size() : window.size() + 1;

        for (int i = 0; i < N; i++) {
            Integer poll = q.poll();
            if(window.get(poll) == 1){
                window.remove(poll);
            } else {
                window.put(poll, window.get(poll) - 1);
            }

            q.add(sushi[(i + k) % N]);
            if (window.get(sushi[(i + k) % N]) != null) {
                window.put(sushi[(i + k) % N], window.get(sushi[(i + k) % N]) + 1);
            } else {
                window.put(sushi[(i + k) % N], 1);
            }

            max = Math.max(max, window.containsKey(c) ? window.size() : window.size() + 1);
        }

        System.out.println(max);
    }
}