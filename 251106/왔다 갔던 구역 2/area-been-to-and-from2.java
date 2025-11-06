import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] index = new int[2001];
        int position = 1000;
        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            char dir = sc.next().charAt(0);
            // Please write your code here.
            for(int k = 0; k < x; k++){
                if(dir == 'R') {
                    index[position]++;
                    position++;
                } else {
                    position--;
                    index[position]++;
                }
            }
        }

        int cnt = 0;
        for(int i = 0; i<=2000; i++) {
            if(index[i] > 1) cnt++;
        }
        System.out.print(cnt);
    }
}