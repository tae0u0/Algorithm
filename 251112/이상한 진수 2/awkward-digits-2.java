import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] a = sc.next().toCharArray();
        boolean flag = false;
        for(int i = 0; i<a.length; i++) {
            if(a[i] == '0') {
                a[i] = '1';
                flag = true;
                break;
            }
        }

        if(!flag) a[a.length - 1] = '0';

        int index = 1;
        int cnt = 0;
        for(int i = a.length - 1; i >= 0; i--) {
            if(a[i] == '1') cnt += index;
            index *= 2;
        }
        System.out.print(cnt);
    }
}