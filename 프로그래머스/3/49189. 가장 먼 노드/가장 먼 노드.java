import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        List<Integer>[] edges = new ArrayList[n+1];
        for(int i = 1; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }
        
        for(int[] e : edge) {
            int a = e[0];
            int b = e[1];
            edges[a].add(b);
            edges[b].add(a);
        }
        
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{1, 0});
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        while(!pq.isEmpty()) {
            int[] poll = pq.poll();
            int cur = poll[0];
            int d = poll[1];
            if(dist[cur] != d) continue;
            
            for(int next : edges[cur]) {
                if(dist[next] > d+1) {
                    pq.add(new int[]{next, d + 1});
                    dist[next] = d + 1;
                }
            }
        }

        int maxNum = 0;
        int answer = 0;
        for(int i = 2; i <= n; i++) {
            if(maxNum < dist[i]) {
                maxNum = dist[i];
                answer = 1;
            } else if(maxNum == dist[i]) {
                answer++;
            }
        }
        return answer;
    }
}