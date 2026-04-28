import java.util.*;

class Solution {
    int[] parents;
    public int solution(int n, int[][] costs) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2])); 
        for(int i = 0 ; i < costs.length; i++) {
            pq.add(costs[i]);
        }
        
        parents = new int[n];
        for(int i = 0; i < n; i++) {
            parents[i] = i;
        }
        
        int cnt = 1;
        int answer = 0;
        while(cnt < n) {
            int[] poll = pq.poll();
            
            if(union(poll[0], poll[1])) {
                cnt++;
                answer += poll[2];
            }
        }
        return answer;
    }
                                                      
    private boolean union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        
        if(pa == pb) return false;
        parents[pa] = pb;
        return true;
    }
                                                      
    private int find(int x) {
        int px = parents[x];
        if(px == x) return px;
        return parents[x] = find(px);
    }
}