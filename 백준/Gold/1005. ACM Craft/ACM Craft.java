import java.io.*;
import java.util.*;

public class Main {
    static int N, K, W;
    static int[] buildingTime;
    static ArrayList<Building>[] sequence;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            buildingTime = new int[N+1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                buildingTime[i] = Integer.parseInt(st.nextToken());
            }

            sequence = new ArrayList[N + 1];

            for (int i = 0; i <= N; i++) {
                sequence[i] = new ArrayList<>();
            }

            for (int i = 1; i <= K; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                sequence[to].add(new Building(from, buildingTime[from]));
            }

            W = Integer.parseInt(br.readLine());

            int answer = solution();
            System.out.println(answer);
        }
    }

    private static int solution() {
        Queue<Building> q = new LinkedList<>();
        q.add(new Building(W, buildingTime[W]));
        int[] spentTime = new int[N + 1];
        spentTime[W] = buildingTime[W];

        while(!q.isEmpty()){
            Building cur = q.poll();
            for(Building building : sequence[cur.num]){
                int nextBuildingTime = spentTime[cur.num] + building.time;
                if(spentTime[building.num] < nextBuildingTime) {
                    spentTime[building.num] = nextBuildingTime;
                    q.add(building);
                }
            }
        }
        Arrays.sort(spentTime);
        return spentTime[N];
    }

    private static class Building {
        int num, time;

        public Building(int num, int time) {
            this.num = num;
            this.time = time;
        }
    }
}
