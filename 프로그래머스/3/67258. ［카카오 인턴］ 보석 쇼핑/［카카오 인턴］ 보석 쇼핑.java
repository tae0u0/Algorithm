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
            window.merge(gems[right], 1, Integer::sum);
            
            if(window.size() == totalTypes) {
                while (window.size() == totalTypes) {
                    String leftGem = gems[left];
                    if (window.get(leftGem) == 1) {
                        window.remove(leftGem);
                    } else {
                        window.merge(leftGem, -1, Integer::sum);
                    }
                    left++;
                }
                
                int windowLen = right - left + 2;
                if (windowLen < minLen) {
                    minLen = windowLen;
                    answer[0] = left;
                    answer[1] = right + 1;
                }
            }
        }

        return answer;
    }
}