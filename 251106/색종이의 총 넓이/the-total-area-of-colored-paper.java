import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x1 = new int[n];
        int[] y1 = new int[n];
        int[] x2 = new int[n];
        int[] y2 = new int[n];
        for (int i = 0; i < n; i++) {
            x1[i] = sc.nextInt() + 100;
            y1[i] = sc.nextInt() + 100;
            x2[i] = x1[i] + 8 > 200 ? 200 : x1[i] + 8;
            y2[i] = y1[i] + 8 > 200 ? 200 : y1[i] + 8;
        }

        int[][] arr = new int[201][201];
        
        for(int i = 0; i<n; i++){
            for(int j = y1[i]; j <y2[i]; j++){
                for(int k = x1[i]; k <x2[i]; k++){
                    arr[j][k]++;
                }
            }
        }

        int cnt = 0;
        for(int i = 0; i<201; i++){
            for(int j=0; j<201; j++){
                if(arr[i][j] > 0) cnt++;
            }
        }
        System.out.print(cnt);
    }
}