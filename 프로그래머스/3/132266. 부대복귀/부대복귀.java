import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        List<Integer>[] adjacent = new ArrayList[n+1];
        for(int i = 1; i < n+1; i++) {
            adjacent[i] = new ArrayList<>();
        }
        
        for(int[] road : roads) {
            int a = road[0];
            int b = road[1];
            adjacent[a].add(b);
            adjacent[b].add(a);
        }
        
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{destination, 0});
        dist[destination] = 0;
        
        while(!pq.isEmpty()) {
            int[] poll = pq.poll();
            int cur = poll[0];
            int cost = poll[1];
            
            if(cost != dist[cur]) continue;
            
            for(int next : adjacent[cur]) {
                if(cost + 1 < dist[next]) {
                    dist[next] = cost + 1;
                    pq.add(new int[]{next, cost + 1});
                }
            }
        } 
        
        int[] answer = new int[sources.length];
        int i = 0;
        for(int index : sources) {
            answer[i++] = dist[index] == Integer.MAX_VALUE ? -1 : dist[index];
        }
        return answer;
    }

}
