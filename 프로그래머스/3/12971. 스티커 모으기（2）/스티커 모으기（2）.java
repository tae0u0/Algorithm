class Solution {
    public int solution(int[] sticker) {
        int n = sticker.length;

        if (n == 1) return sticker[0];
        if (n == 2) return Math.max(sticker[0], sticker[1]);

        int result1 = rob(sticker, 0, n - 2);
        int result2 = rob(sticker, 1, n - 1);

        return Math.max(result1, result2);
    }

    private int rob(int[] sticker, int start, int end) {
        if (start == end) return sticker[start];

        int prev2 = sticker[start];
        int prev1 = Math.max(sticker[start], sticker[start + 1]);

        for (int i = start + 2; i <= end; i++) {
            int curr = Math.max(prev1, prev2 + sticker[i]);
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}