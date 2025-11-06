import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] index = new int[200_001];
        int cur = 100_000;
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            char d = sc.next().charAt(0);

            if(d == 'L') {
                while(x-- > 0) {
                    index[cur] = 1;
                    if(x < 1) break;
                    cur--;
                }
            } else {
                while(x-- > 0) {
                    index[cur] = 2;
                    if(x < 1) break;
                    cur++;
                }
            }
        }
        // Please write your code here.
        int white = 0, black = 0;

        for(int i = 0; i< 200_001; i++) {
            if(index[i] == 1) white++;
            else if(index[i] == 2) black++;
        }

        System.out.print(white + " " + black);
    }
}