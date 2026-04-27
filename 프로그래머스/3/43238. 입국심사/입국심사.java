class Solution {
    public long solution(int n, int[] times) {
        
        long left = 1; 
        long right = 1L << 60;
        long answer = 0;
        
        while(left <= right) {
            long mid = left + (right - left) / 2;
            long cnt = getNumber(mid, times);
            if(cnt >= n) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }
    
    private long getNumber(long time, int[] workTimes) {
        long cnt = 0;
        for(int wt : workTimes) {
            cnt += (time / wt);
        }
        return cnt;
    }
}