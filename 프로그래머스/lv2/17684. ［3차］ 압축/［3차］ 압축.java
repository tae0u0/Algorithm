import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(String msg) {
        List<String> arr = new ArrayList<>();
        List<Integer> index = new ArrayList<>();

        arr.add("dummy"); 
        for (int i = 0; i < 26; i++) {
            arr.add(Character.toString((char) ('A' + i)));
        }

        int i = 0;
        while (i < msg.length()) {
            int end = i + 1;

            while (end <= msg.length() && arr.contains(msg.substring(i, end))) {
                end++;
            }

            if (end <= msg.length()) {
                arr.add(msg.substring(i, end));
            }

            index.add(arr.indexOf(msg.substring(i, end - 1)));

            i += (end - 1 - i);
        }

        int[] answer = new int[index.size()];
        for (int j = 0; j < index.size(); j++) {
            answer[j] = index.get(j);
        }

        return answer;
    }
}
