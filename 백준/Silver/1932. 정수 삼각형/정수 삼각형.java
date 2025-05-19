import java.util.*;

public class Main {
    static int[][] trees;
    static int level;
    static Integer[][] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        level = sc.nextInt();
        sc.nextLine();
        trees = new int[level + 1][level + 1];
        dp = new Integer[level + 1][level + 1];


        for (int i = 1; i <= level; i++) {
            String[] split = sc.nextLine().split(" ");
            for (int j = 0; j < split.length; j++) {
                trees[i][j+1] = Integer.parseInt(split[j]);
            }
        }

        int answer = dp(1, 1);
        System.out.println(answer);
    }

    private static int dp(int depth, int index){
        if(depth == level){
            return dp[depth][index] == null ? trees[depth][index] : dp[depth][index];
        }

        if(dp[depth][index] != null){
            return dp[depth][index];
        }

        int left = dp(depth+1, index);
        int right = dp(depth+1, index+1);

        dp[depth][index] = trees[depth][index] + Math.max(left, right);
        return dp[depth][index];
    }
}