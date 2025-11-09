import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        int[] A = new int[1_000_001];
        int[] B = new int[1_000_001];
        // Please write your code here.
        int time = 0;
        int cur = 0;
        for(int i = 0; i<n; i++){
            String dir = sc.next();
            int num = sc.nextInt();
            if(dir.equals("R")){
                for(int k = 0; k<num; k++){
                    time++;
                    A[time] = ++cur;
                }
            } else {
                for(int k = 0; k<num; k++){
                    time++;
                    A[time] = --cur;
                }
            }
        }

        time = 0;
        cur = 0;
        for(int i = 0; i<m; i++){
            String dir = sc.next();
            int num = sc.nextInt();
            if(dir.equals("R")){
                for(int k = 0; k<num; k++){
                    time++;
                    B[time] = ++cur;
                }
            } else {
                for(int k = 0; k<num; k++){
                    time++;
                    B[time] = --cur;
                }
            }
        }

        int result = -1;
        for(int i = 1; i<=time; i++){
            if(A[i] == B[i]) {
                result = i;
                break;
            }
        }
        System.out.print(result);
    }
}