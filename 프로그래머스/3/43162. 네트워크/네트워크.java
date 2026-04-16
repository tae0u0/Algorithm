import java.util.*;

class Solution {
    private boolean[] used;
    private int N;
    public int solution(int n, int[][] computers) {
        N = computers.length;
        used = new boolean[N];
        int answer = 0;
        for(int i = 0; i < N; i++) {
            if(!used[i]) {
                bfs(i, computers);
                answer++;
            }
        }
        return answer;
    }
    
    private void bfs(int start, int[][] computers) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        used[start] = true;
        while(!q.isEmpty()) {
            int cur = q.poll();
            
            for(int next = 0; next < N; next++) {
                if(computers[cur][next] == 1 && !used[next]) {
                    used[next] = true;
                    q.add(next);
                } 
            }
        }
    }
}