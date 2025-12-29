import java.util.*;
import java.io.*;

public class Main {
    static int N, M, R;
    static int[] item;
    static ArrayList<int[]>[] adjacent;
    static int[][] arr;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        item = new int[N+1];
        adjacent = new ArrayList[N+1];
        arr = new int[N+1][N+1];
        for (int i = 0; i <= N; i++) {
            adjacent[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            item[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());
            adjacent[first].add(new int[]{second, len});
            adjacent[second].add(new int[]{first, len});
        }

        for (int i = 1; i <= N ; i++) {
            Arrays.fill(arr[i], INF);
            for(int j = 0; j < adjacent[i].size(); j++) {
                int[] ints = adjacent[i].get(j);
                int dest = ints[0];
                int len = ints[1];
                arr[i][dest] = len;
            }
            arr[i][i] = 0;
        }

        for(int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if(arr[i][k] == INF || arr[k][j] == INF) continue;
                    arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                }
            }
        }

        int rst = 0;
        for (int i = 1; i <= N; i++) {
            int itemNum = 0;
            for (int j = 1; j <=N ; j++) {
                if(arr[i][j] <= M) itemNum += item[j];
            }
            rst = Math.max(itemNum, rst);
        }

        System.out.println(rst);
    }
}
