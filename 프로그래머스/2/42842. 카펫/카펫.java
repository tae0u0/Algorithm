import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int fullCarpet = brown + yellow;
        
        // 갈색 2개, 노란색 1개로 가장 작은 크기가 3
        for(int brownY = 3; brownY <= Math.sqrt(fullCarpet); brownY++) {
            int brownX = fullCarpet / brownY;
            // 나누어 떨어지고, 노랑색 카펫의 크기가 맞다면
            if(fullCarpet % brownY == 0 && (brownX - 2) * (brownY - 2) == yellow) {
                answer[0] = brownX;
                answer[1] = brownY;
                break;
            }
        }

        return answer;
    }
}