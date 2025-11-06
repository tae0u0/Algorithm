import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] start = new int[n];
        int[] end = new int[n];
        for (int i = 0; i < n; i++) {
            start[i] = sc.nextInt();
            end[i] = sc.nextInt();
        }
        // Please write your code here.

        int[] index = new int[101];
        for (int i = 0; i < n; i++) {
            for(int k = start[i]; k <= end[i]; k++) {
                index[k]++;
            }
        }

        int max = 0;
        for(int i : index) {
            if(i > max) max = i;
        }

        System.out.print(max);
    }
}