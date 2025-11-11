import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] str = sc.next().toCharArray();
        
        int cnt = 0;
        for(int i = 0; i<str.length; i++) {
            if(str[i] == '(') {
                for(int j = i + 1; j < str.length; j++) {
                    if(str[j] == ')') {
                        cnt++;
                    }
                }
            } 
        }
        System.out.print(cnt);
    }
}