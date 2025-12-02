import java.util.*;

public class Main {
    static int N;
    static List<Member> arr = new ArrayList<>();
    static class Member {
        int age;
        String name;

        public Member(int age, String name) {
            this.age = age;
            this.name = name;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            arr.add(new Member(sc.nextInt(), sc.next()));
        }

        arr.sort(Comparator.comparingInt(o -> o.age));
        StringBuilder sb = new StringBuilder();
        for (Member o : arr) {
            sb.append(o.age).append(" ").append(o.name).append("\n");
        }
        System.out.println(sb);
    }
}