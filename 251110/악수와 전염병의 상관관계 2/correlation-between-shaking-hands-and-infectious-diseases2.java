import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int P = sc.nextInt();
        int T = sc.nextInt();
        int[][] shakes = new int[T][3];
        int[] epidemics = new int[N+1];
        boolean[] isInfected = new boolean[N+1];
        isInfected[P] = true;
        Arrays.fill(epidemics, K);
        for (int i = 0; i < T; i++) {
            shakes[i][0] = sc.nextInt();    // t
            shakes[i][1] = sc.nextInt();    // x
            shakes[i][2] = sc.nextInt();    // y
        }
        // Please write your code here.
        Arrays.sort(shakes, (x, y) -> {
            return x[0] - y[0];
        });

        for(int i = 0; i<T; i++){
            int x = shakes[i][1];
            int y = shakes[i][2];
            epidemics[x]--;
            epidemics[y]--;
            if((isInfected[x] && epidemics[x] >= 0) || (isInfected[y] && epidemics[y] >= 0)) {
                isInfected[x] = true;
                isInfected[y] = true;
            }
        }

         for (int i = 1; i <= N; i++) {
            if(isInfected[i]) System.out.print(1);
            else System.out.print(0);
        }
    }
}