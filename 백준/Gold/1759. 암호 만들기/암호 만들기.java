import java.io.*;
import java.util.*;

public class Main {
    private static int L, C;
    private static char[] arr, alpha;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new char[C];
        alpha = new char[L];

        for (int i = 0; i < C; i++) {
            arr[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(arr);
        back(0, 0);
        System.out.println(sb.toString());
    }

    private static void back(int depth, int index) {
        if(index == C && depth < L) return;
        if(depth == L) {
            if(check()) {
                for (int i = 0; i < L; i++) {
                    sb.append(alpha[i]);
                }
                sb.append('\n');
            }
            return;
        }

        alpha[depth] = arr[index];
        back(depth + 1, index + 1);
        back(depth, index + 1);
    }

    private static boolean check() {
        int mo = 0, ja = 0;

        for (int i = 0; i < L; i++) {
            if(alpha[i] == 'a' || alpha[i] == 'e' || alpha[i] == 'i' || alpha[i] == 'o' || alpha[i] == 'u') {
                mo++;
            } else {
                ja++;
            }
        }

        return mo >= 1 && ja >= 2;
    }
}