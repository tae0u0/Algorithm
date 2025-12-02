import java.util.*;

public class Main {
    static int N;
    static Set<String> arr = new HashSet<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < N; i++) {
            arr.add(sc.nextLine());
        }

        List<String> list = new ArrayList<>(arr);
        list.sort((o1, o2) -> {
            if (o1.length() != o2.length()) {
                return o1.length() - o2.length();
            }
            int i = 0;
            for (; i < o1.length(); i++) {
                if (o1.charAt(i) != o2.charAt(i))
                    break;
            }
            return o1.charAt(i) - o2.charAt(i);
        });

        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s).append("\n");
        }
        System.out.println(sb);
    }
}