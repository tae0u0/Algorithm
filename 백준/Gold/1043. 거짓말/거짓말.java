import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] parents, level;
    static List<List<Integer>> party = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parents = new int[N + 1];
        level = new int[N + 1];
        for (int i = 1; i <= N; i++) parents[i] = i;

        st = new StringTokenizer(br.readLine());
        int truthNum = Integer.parseInt(st.nextToken());
        int rootTruth = 0;

        for (int i = 0; i < truthNum; i++) {
            int t = Integer.parseInt(st.nextToken());
            union(rootTruth, t);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int partyCount = Integer.parseInt(st.nextToken());

            List<Integer> members = new ArrayList<>();
            for (int j = 0; j < partyCount; j++) {
                members.add(Integer.parseInt(st.nextToken()));
            }
            party.add(members);

            for (int j = 1; j < members.size(); j++) {
                union(members.get(0), members.get(j));
            }
        }

        int cnt = 0;

        for (List<Integer> members : party) {
            boolean ok = true;

            for (int person : members) {
                if (find(person) == find(rootTruth)) {
                    ok = false;
                    break;
                }
            }

            if (ok) cnt++;
        }

        System.out.println(cnt);
    }

    private static int find(int x) {
        if (parents[x] == x) return x;
        return parents[x] = find(parents[x]);
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x == y) return;

        if (level[x] > level[y]) {
            parents[y] = x;
        } else {
            parents[x] = y;
            if (level[x] == level[y]) level[y]++;
        }
    }
}
