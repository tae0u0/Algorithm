import java.util.Arrays;

class Solution {
    public String[] solution(String[] input) {
        File[] files = new File[input.length];
        String[] answer = new String[input.length];
        int digit_start_index, digit_end_index;

        for (int i = 0; i < input.length; i++) {
            digit_start_index = -1;
            digit_end_index = -1;
            String filename = input[i];

            // 숫자 시작/끝 인덱스 찾기
            for (int j = 0; j < filename.length(); j++) {
                if (Character.isDigit(filename.charAt(j))) {
                    if (digit_start_index == -1) {
                        digit_start_index = j;
                    }
                } else {
                    if (digit_start_index != -1) {
                        digit_end_index = j;
                        break;
                    }
                }
            }

            // 숫자 끝이 문자열 끝까지일 경우
            if (digit_start_index != -1 && digit_end_index == -1) {
                digit_end_index = filename.length();
            }

            // 숫자는 최대 5자리까지만 파싱
            int end = Math.min(digit_start_index + 5, digit_end_index);

            files[i] = new File(
                filename,
                filename.substring(0, digit_start_index).toLowerCase(),
                Integer.parseInt(filename.substring(digit_start_index, end))
            );
        }

        Arrays.sort(files);

        for (int i = 0; i < files.length; i++) {
            answer[i] = files[i].filename;
        }
        return answer;
    }

    static class File implements Comparable<File> {
        String filename;
        String head;
        int number;

        public File(String filename, String head, int number) {
            this.filename = filename;
            this.head = head;
            this.number = number;
        }

        public int compareTo(File o) {
            if (this.head.equals(o.head)) {
                return this.number - o.number;
            }
            return this.head.compareTo(o.head);
        }
    }
}
