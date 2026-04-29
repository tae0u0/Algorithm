class Solution {
    public long solution(int[] sequence) {
        int N = sequence.length;
        int[] arr = new int[N];
        int mul = 1;
        for(int i = 0; i < N; i++) {
            arr[i] = sequence[i] * mul;
            mul = -mul;
        }
        
        long maxNum = 0;
        long minNum = Long.MAX_VALUE;
        long prevPos = 0;
        long prevNeg = 0;
        for(int i = 0; i < N; i++) {
            long sumPos = prevPos + arr[i];
            long sumNeg = prevNeg + arr[i];
            
            if(sumPos > 0) {
                maxNum = Math.max(maxNum, sumPos);
                prevPos = sumPos;
            } else {
                prevPos = 0;
            }
            
            if(sumNeg < 0) {
                minNum = Math.min(minNum, sumNeg);
                prevNeg = sumNeg;
            } else {
                prevNeg = 0;
            }
        }
        long answer = Math.max(maxNum, -minNum);
        return answer;
    }
}