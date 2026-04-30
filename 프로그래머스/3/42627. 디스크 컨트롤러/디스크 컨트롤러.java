import java.util.*;

class Solution {
    int N;
    static class Job implements Comparable<Job> {
        int num, s, i;
        
        Job(int num, int s, int i) {
            this.num = num;
            this.s = s;
            this.i = i;
        }
        
        public int compareTo(Job o) {
            if(this.i == o.i) {
                if(this.s == o.s) {
                    return this.num - o.num;
                }
                return this.s - o.s;
            }
            return this.i - o.i;
        }
    }
    public int solution(int[][] jobs) {
        N = jobs.length;
        Queue<Job> pq = new PriorityQueue<>();
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
       
        int time = 0;
        int answer = 0;
        int idx = 0;
        while(idx < N || !pq.isEmpty()) {
            while(idx < N && jobs[idx][0] <= time) {
                pq.add(new Job(idx, jobs[idx][0], jobs[idx][1]));
                idx++;
            }
            
            if (pq.isEmpty()) {
                time = jobs[idx][0];
                continue;
            }
            
            Job poll = pq.poll();
            time = Math.max(time, poll.s);
            time+= poll.i;
            answer += (time - poll.s);
        }
        
        return answer / N;
    }
}