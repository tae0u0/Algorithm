class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int prev = 0;
        int propagation = 2 * w + 1;
        for(int i = 0; i < stations.length; i++) {
            int left = stations[i] - w - 1 - prev;
            if(left < 0) {
                prev = stations[i] + w;
                continue;
            }
            answer += left / propagation;
            answer += left % propagation == 0 ? 0 : 1;
            prev = stations[i] + w;
        }
        
        if(stations[stations.length-1] + w >= n) return answer;
        
        answer += (n - (stations[stations.length-1] + w)) / propagation;
        answer += (n - (stations[stations.length-1] + w)) % propagation == 0 ? 0 : 1;
       

        return answer;
    }
}