import java.util.*;

public class Main {
    static int N, M, H;
    static boolean[][] ladder;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        H = sc.nextInt();

        ladder = new boolean[H + 1][N + 1];

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            ladder[a][b] = true;
        }

        dfs(0, 1, 1);

        System.out.println(answer > 3 ? -1 : answer);
    }

    private static void dfs(int count, int y, int x){
        if(check()){
            answer = Math.min(answer, count);
            return;
        }

        if(count == 3 || count >= answer) return;

        for (int i = y; i <= H; i++) {
            for (int j = (i == y ? x : 1); j < N; j++) {
                if(ladder[i][j] || ladder[i][j+1] || ladder[i][j-1] ) continue;

                ladder[i][j] = true;
                dfs(count + 1, i, j);
                ladder[i][j] = false;
            }
        }

    }

    private static boolean check() {
        for (int start = 1; start <= N; start++) {
            int pos = start;
            for (int j = 1; j <= H ; j++) {
                if(ladder[j][pos]){
                    pos++;
                } else if (ladder[j][pos-1]) {
                    pos--;
                }
            }
            if(pos != start)
                return false;
        }
        return true;
    }
}
