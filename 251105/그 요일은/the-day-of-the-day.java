import java.util.Scanner;

public class Main {
    static int[] num_of_days = new int[]{0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m1 = sc.nextInt();
        int d1 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();
        String A = sc.next();
        
        int first = d1, second = d2;

        for(int i = 1; i<m1; i++) first += num_of_days[i];
        for(int i = 1; i<m2; i++) second += num_of_days[i];

        int dist = second - first + 1;

        int dist_day_num = getDay(A);
        int ans = 0;
        if(dist % 7 >= dist_day_num) ans++;
        
        System.out.print(dist / 7 + ans);
    }

    private static int getDay(String A) {
        if(A.equals("Mon")) return 1;
        else if(A.equals("Tue")) return 2;
        else if(A.equals("Wen")) return 3;
        else if(A.equals("Thu")) return 4;
        else if(A.equals("Fri")) return 5;
        else if(A.equals("Sat")) return 6;
    
        return 0;
    }
}