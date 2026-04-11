import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int L = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        char[] chars = new char[C];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) chars[i] = st.nextToken().charAt(0);
        Arrays.sort(chars);

        String vowels = "aeiou";
        List<String> result = new ArrayList<>();

        for (int mask = 0; mask < (1 << C); mask++) {
            if (Integer.bitCount(mask) != L) continue;

            StringBuilder combo = new StringBuilder();
            int v = 0;
            for (int i = 0; i < C; i++) {
                if ((mask & (1 << i)) != 0) {
                    combo.append(chars[i]);
                    if (vowels.indexOf(chars[i]) != -1) v++;
                }
            }

            int con = L - v;
            if (v >= 1 && con >= 2)
                result.add(combo.toString());
        }

        Collections.sort(result);
        StringBuilder sb = new StringBuilder();
        for (String s : result) sb.append(s).append("\n");
        System.out.print(sb);
    }
}