import java.util.Scanner;
public class Main {
    static int[] num_of_days = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m1 = sc.nextInt();
        int d1 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();
        // Please write your code here.
        int first = d1, second = d2;

        for(int i = 1; i<m1; i++) first += num_of_days[i];
        for(int i = 1; i<m2; i++) second += num_of_days[i];

        int dist = (second - first) % 7;
        if(dist < 0) dist += 7;

        switch(dist) {
            case 1:
                System.out.print("Tue");
                break;
            case 2:
                System.out.print("Wed");
                break;
            case 3:
                System.out.print("Thu");
                break;
            case 4:
                System.out.print("Fri");
                break;
            case 5:
                System.out.print("Sat");
                break;
            case 6:
                System.out.print("Sun");
                break;
            default:
                System.out.print("Mon");
        }
    }
}