import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        Queue<Integer> pqMax = new PriorityQueue<>((a, b) -> b-a);
        Queue<Integer> pqMin = new PriorityQueue<>();
        
        for(int i = 0; i< operations.length; i++) {
            StringTokenizer st = new StringTokenizer(operations[i]);
            String cmd = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            
            if(cmd.equals("I")) {
                pqMax.add(num);
                pqMin.add(num);
            } else {
                if(pqMax.isEmpty()) continue;
                if(num == 1) {
                    int poll = pqMax.poll();
                    pqMin.remove(Integer.valueOf(poll));
                } else {
                    int poll = pqMin.poll();
                    pqMax.remove(Integer.valueOf(poll));
                }
            }
        }
    
        int[] answer = new int[2];
        answer[0] = pqMax.isEmpty() ? 0 : pqMax.poll();
        answer[1] = pqMin.isEmpty() ? 0 : pqMin.poll();
        return answer;
    }
}