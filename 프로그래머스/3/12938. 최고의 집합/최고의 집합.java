class Solution {
    public int[] solution(int n, int s) {
        int quotient = s / n;
        int remain = s % n;
        
        if(n > s) return new int[]{-1};
        int[] answer = new int[n];
        int i = 0;
        for(; i < n - remain; i++) {
            answer[i] = quotient;
        }
        for(; i < n; i++) {
            answer[i] = quotient + 1;
        }
        return answer;
    }
}