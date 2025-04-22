import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int L = sc.nextInt();
        int[][] map = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int answer = 0;

        for (int i = 0; i < N; i++) {
            if (canPlaceSlope(map[i], L)) {
                answer++;
            }
        }

        for (int i = 0; i < N; i++) {
            int[] column = new int[N];
            for (int j = 0; j < N; j++) {
                column[j] = map[j][i];
            }
            if (canPlaceSlope(column, L)) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    static boolean canPlaceSlope(int[] line, int L) {
        boolean[] visited = new boolean[line.length];
        for (int i = 0; i < line.length - 1; i++) {
            if (Math.abs(line[i] - line[i + 1]) > 1) {
                return false;
            }

            if (line[i] < line[i + 1]) {
                if (i - L + 1 < 0) return false;
                for (int j = i; j > i - L; j--) {
                    if (line[j] != line[i] || visited[j]) return false;
                    visited[j] = true;
                }
            } else if (line[i] > line[i + 1]) {
                if (i + L >= line.length) return false;
                for (int j = i + 1; j <= i + L; j++) {
                    if (line[j] != line[i + 1] || visited[j]) return false;
                    visited[j] = true;
                }
            }
        }

        return true;
    }
}
