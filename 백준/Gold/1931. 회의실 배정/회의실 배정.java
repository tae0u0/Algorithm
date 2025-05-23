import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static ArrayList<Meeting> meetings = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            meetings.add(new Meeting(start, end));
        }

        Collections.sort(meetings);

        int answer = 1;
        Meeting meeting = meetings.get(0);
        for (int i = 1; i < meetings.size(); i++) {
            if(meeting.end <= meetings.get(i).start) {
                meeting = meetings.get(i);
                answer++;
            }
        }
        System.out.println(answer);
    }

    private static class Meeting implements Comparable<Meeting> {
        int start, end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meeting o) {
            if(this.end != o.end) {
                return Integer.compare(this.end, o.end);
            } else {
                return Integer.compare(this.start, o.start);
            }
        }
    }
}