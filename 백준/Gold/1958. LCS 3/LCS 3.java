import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String first = sc.nextLine();
        String second = sc.nextLine();
        String third = sc.nextLine();

        int[][][] dp = new int[first.length() + 1][second.length() + 1][third.length() + 1];

        for (int i = 1; i <= first.length(); i++) {
            for (int j = 1; j <= second.length(); j++) {
                for (int k = 1; k <= third.length() ; k++) {
                    if(first.charAt(i - 1) == second.charAt(j - 1) && first.charAt(i - 1) == third.charAt(k - 1)) {
                        dp[i][j][k] = dp[i-1][j-1][k-1] + 1;
                    } else {
                        dp[i][j][k] = Math.max(dp[i-1][j][k], dp[i][j-1][k]);
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i][j][k-1]);
                    }
                }
            }
        }

        System.out.println(dp[first.length()][second.length()][third.length()]);
    }
}