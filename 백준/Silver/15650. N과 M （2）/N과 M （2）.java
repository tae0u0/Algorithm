import java.util.Scanner;

public class Main {
    static int N, M;
    static int[] index;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        index = new int[M];

        backtrack(0, 1);
    }

    private static void backtrack(int depth, int start) {
        if (depth == M) {
            for (int i : index) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i <= N; i++) {
            index[depth] = i;
            backtrack(depth + 1, i + 1);
        }
    }
}