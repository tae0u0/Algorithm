import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] white = new int[200_001];
        int[] black = new int[200_001];
        char[] cur_color = new char[200_001];
        int position = 100_000;
        int x1, x2;
        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            char d = sc.next().charAt(0);

            if(d == 'R') {
                x1 = position;
                x2 = position + x - 1;
                position = position + x - 1;
            } else {
                x1 = position - x + 1;
                x2 = position;
                position = position - x + 1;
            }

            for(int k = x1; k <= x2; k++){
                if(d == 'R') {
                    cur_color[k] = 'b';
                    black[k]++;
                } else {
                    cur_color[k] = 'w';
                    white[k]++;
                }
            }
        }
    
        int gray_num = 0, white_num = 0, black_num = 0;
        for(int i = 0; i<200_001; i++){
            if(black[i] > 1 && white[i] > 1){
                gray_num++;
                continue;
            }

            if(cur_color[i] == 'b') black_num++;
            else if(cur_color[i] == 'w') white_num++;
        }
        System.out.print(white_num + " " + black_num + " " + gray_num);
    }
}
