import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main{
    static int N;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int[] num, operator;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        num = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        operator = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        solve(1, num[0]);
        System.out.println(max);
        System.out.println(min);
    }

    static void solve(int index, int result) {
        if (index == N) {
            max = Math.max(result, max);
            min = Math.min(result, min);
            return;
        }
        
        for (int i = 0; i < 4; i++) {
            if(operator[i] != 0){
                operator[i]--;
                int cal_result = cal(index, i, result);
                solve(index+1, cal_result);
                operator[i]++;
            }
        }
    }
    
    static int cal(int num_index, int oper_index, int result) {
        switch(oper_index){
            case 0:
                return result + num[num_index];
            case 1:
                return result - num[num_index];
            case 2:
                return result * num[num_index];
            default:
                return result / num[num_index];
        }
    }
}