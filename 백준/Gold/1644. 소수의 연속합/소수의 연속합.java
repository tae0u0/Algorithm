import java.util.*;

public class Main {
    static int N;
    static boolean[] prime;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        prime = new boolean[N + 1];
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;

        for (int i = 2; i * i <= N; i++) {
            if(prime[i]) {
                for (int j = i * i; j <= N; j += i) {
                    prime[j] = false;
                }
            }
        }

        int cnt = 0, sum = 2;
        int left = 2, right = 3;

        while(left <= N) {
            if(right <= N && !prime[right]) {
                right++;
                continue;
            }

            if(!prime[left]) {
                left++;
                continue;
            }

            if(sum > N) {
                sum -= left;
                left++;
            } else if(sum < N) {
                sum += right;
                right++;
            } else {
                cnt++;
                sum -= left++;
            }
        }

        System.out.println(cnt);
    }

}
