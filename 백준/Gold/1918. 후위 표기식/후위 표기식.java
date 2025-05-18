import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] input = sc.nextLine().toCharArray();

        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < input.length; i++) {
            char c = input[i];
            if(Character.isAlphabetic(c)){
                sb.append(c);
                continue;
            }

            if(c == '('){
                st.push('(');
            }
            else if (c == ')') {
                while(!st.isEmpty() && st.peek() != '('){
                    sb.append(st.pop());
                }
                st.pop();
            } else {
                while(!st.isEmpty() && isPriority(c) <= isPriority(st.peek())){
                    sb.append(st.pop());
                }
                st.push(c);
            }

        }
        while(!st.empty()){
            sb.append(st.pop());
        }

        System.out.println(sb);

    }

    private static int isPriority(char c) {
        if(c == '*' || c == '/')
            return 2;
        else if (c == '+' || c == '-')
            return 1;
        else
            return 0;
    }
}