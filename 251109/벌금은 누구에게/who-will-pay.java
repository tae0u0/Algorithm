import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int[] penalizedPerson = new int[m];
        for (int i = 0; i < m; i++) {
            penalizedPerson[i] = sc.nextInt();
        }
        // Please write your code here.
        int[] penalty = new int[n+1];
        int result = -1;
        for(int person_num : penalizedPerson){
            if(k <= ++penalty[person_num]) {
                result = person_num;
                break;
            }
        }
        System.out.print(result);

    }
}