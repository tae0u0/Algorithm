import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        int rst = (A*24*60 + B*60 + C) - (11*24*60 + 11*60 + 11);
        if(rst < 0) {
            System.out.print(-1);
        } else {
            System.out.print(rst);
        }
    }
}