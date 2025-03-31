import java.util.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] result = new String[n];

        for(int i = 0; i<n; i++){
            String binaryString = Integer.toBinaryString(arr1[i] | arr2[i]);
            binaryString = String.format("%" + n + "s", binaryString).replace(' ', '0');
        
            char[] charArray = binaryString.toCharArray();
            for (int j = 0; j < charArray.length; j++) {
                charArray[j] = (charArray[j] == '0') ? ' ' : '#';
            }

            result[i] = new String(charArray);
        }

        return result;
    }
}