import java.util.ArrayList;
import java.util.StringTokenizer;

class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        ArrayList<Character> arr = new ArrayList<>();
        int num = 0;
        int turn = 0;
        
        while(arr.size() < t){
            String numToString = Integer.toString(num++, n).toUpperCase();
            for (int i = 0; i < numToString.length(); i++) {
                if (turn % m == p-1)
                    arr.add(numToString.charAt(i));
                turn++;
            }
        }

        for (int i = 0; i < t; i++) {
            sb.append(arr.get(i));
        }
        
        String answer = sb.toString();
        return answer;
    }
}