import java.util.*;

public class Main {
    static int N, M;
    static ArrayList<Integer> li = new ArrayList<>();
    static ArrayList<String> seq = new ArrayList<>();
    static int[] selected;
    static ArrayList<Integer> indexes = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        selected = new int[M];

        for (int i = 0; i < N; i++) {
            li.add(sc.nextInt());
        }

        li.sort(Integer::compare);
        backtrack(0);

        for(String str : seq) {
            System.out.println(str);
        }
    }

    private static void backtrack(int depth) {
        if(depth == M) {
            StringBuilder sb = new StringBuilder();
            for(int num : selected) {
                sb.append(num).append(" ");
            }
            String str = sb.toString();

            if(!seq.contains(str)){
                seq.add(str);
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            if(indexes.contains(i))
                continue;
            indexes.add(i);
            selected[depth] = li.get(i);
            backtrack(depth + 1);
            indexes.remove(indexes.size()-1);
        }
    }
}