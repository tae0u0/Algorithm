import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        
        int A = sc.nextInt(); // 미래 진법
        int B = sc.nextInt(); // 정이가 사용하는 진법
        int m = sc.nextInt(); // 자릿수의 개수
        
        // 1. A진법 -> 10진수 변환
        long decimalValue = 0;
        for (int i = 0; i < m; i++) {
            int digit = sc.nextInt();
            // 각 자릿수에 A의 거듭제곱을 곱하며 더함
            // 앞에서부터 입력되므로 (기존 합 * A + 현재 자리수) 방식이 효율적
            decimalValue = decimalValue * A + digit;
        }
        
        // 2. 10진수 -> B진법 변환
        if (decimalValue == 0) {
            System.out.println(0);
            return;
        }
        
        Stack<Long> stack = new Stack<>();
        while (decimalValue > 0) {
            stack.push(decimalValue % B);
            decimalValue /= B;
        }
        
        // 3. 스택을 이용해 역순 출력
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}