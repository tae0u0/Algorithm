import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++)
            A[i] = sc.nextInt();
        int[] B = new int[M];
        for (int i = 0; i < M; i++)
            B[i] = sc.nextInt();
        // Please write your code here.
        ArrayList<Integer> list = new ArrayList<>();
        int rst = 0;
        for(int i = 0; i <= N - M; i++) {
            for(int j = i; j < i + M; j++) {
                list.add(A[j]);
            }

            for(int k = 0; k < M; k++) {
                if(list.contains(B[k])) {
                    list.remove(Integer.valueOf(B[k]));
                }
            }
            if(list.isEmpty()) rst++;
            list.clear();
        }

        System.out.print(rst);

    }
}