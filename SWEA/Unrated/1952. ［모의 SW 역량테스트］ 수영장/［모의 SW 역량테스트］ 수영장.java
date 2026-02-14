import java.util.*;
import java.io.*;

public class Solution {
    private static int T, minNum;
    private static int[] ticketCost, usagePlan;
    private final static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            ticketCost = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            usagePlan = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            minNum = INF;

            solve(1, 0);
            sb.append("#").append(testCase).append(" ").append(minNum).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void solve(int month, int sum) {
        if(month > 12) {
            minNum = Math.min(sum, minNum);
            return;
        }

        if(usagePlan[month-1] == 0) {
            solve(month+1, sum);
            return;
        }

        for (int ticketType = 0; ticketType < 4; ticketType++) {
            int[] cal = execute(ticketType, month);
            int costSum = sum + cal[0];
            int nextMonth = cal[1];
            if(costSum < minNum) solve(nextMonth, costSum);
        }
    }

    // cost, 다음 month 반환
    private static int[] execute(int ticketType, int month) {
        // 1일권
        if(ticketType == 0) {
            int cost = usagePlan[month - 1] * ticketCost[ticketType];
            return new int[]{cost, month + 1};
        }
        // 1달 이용권
        else if(ticketType == 1) {
            int cost = ticketCost[ticketType];
            return new int[]{cost, month + 1};
        }
        // 3달 이용권
        else if(ticketType == 2) {
            int cost = ticketCost[ticketType];
            return new int[]{cost, month + 3};
        }
        // 1년 이용권
        else if(ticketType == 3) {
            int cost = ticketCost[ticketType];
            return new int[]{cost, month + 12};
        }
        return new int[]{INF, INF};
    }
}
