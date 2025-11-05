import java.util.Scanner;
public class Main {
    static int[] num_of_days = {
        0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
    };
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m1 = sc.nextInt();
        int d1 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();
        
        int first = d1, second = d2;
        for(int i=1; i<=m1; i++){
            first += num_of_days[i];
        }

        for(int i=1; i<=m2; i++){
            second += num_of_days[i];
        }

        System.out.print(second - first);
    }
}