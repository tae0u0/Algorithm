import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        Set<String> gemSet = new HashSet<>(Arrays.asList(gems));
        int totalTypes = gemSet.size();

        Map<String, Integer> window = new HashMap<>();
        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int[] answer = new int[2];

        for (int right = 0; right < gems.length; right++) {
            // 오른쪽 확장: 현재 보석 추가
            window.merge(gems[right], 1, Integer::sum);

            // 모든 종류가 포함됐을 때, 왼쪽을 최대한 줄임
            while (window.size() == totalTypes) {
                int windowLen = right - left + 1;
                if (windowLen < minLen) {
                    minLen = windowLen;
                    answer[0] = left + 1; // 1-indexed
                    answer[1] = right + 1;
                }

                // 왼쪽 포인터 이동
                String leftGem = gems[left];
                if (window.get(leftGem) == 1) {
                    window.remove(leftGem); // 제거 시 종류 감소
                } else {
                    window.merge(leftGem, -1, Integer::sum);
                }
                left++;
            }
        }

        return answer;
    }
}