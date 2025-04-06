import java.io.*;
import java.util.*;

public class Main {

    static int n, m, dist, res;
    static int[] archer = new int[3];
    static int[][] castleMap;
    static List<int[]> monsterGroup = new ArrayList<>();

    static class Node implements Comparable<Node> {
        int x, y, d;
        Node(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }

        @Override
        public int compareTo(Node o) {
            return this.d == o.d ? this.y - o.y : this.d - o.d;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        dist = Integer.parseInt(st.nextToken());

        castleMap = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                castleMap[i][j] = Integer.parseInt(st.nextToken());
                if (castleMap[i][j] == 1) monsterGroup.add(new int[]{i, j});
            }
        }

        setArchers(0, 0);
        System.out.println(res);
        br.close();
    }

    private static void setArchers(int depth, int start) {
        if (depth == 3) {
            List<int[]> copiedGroup = deepCopy(monsterGroup);
            simulateBattle(copiedGroup);
            return;
        }

        for (int i = start; i < m; i++) {
            archer[depth] = i;
            setArchers(depth + 1, i + 1);
        }
    }

    private static List<int[]> deepCopy(List<int[]> original) {
        List<int[]> copy = new ArrayList<>();
        for (int[] enemy : original) {
            copy.add(new int[]{enemy[0], enemy[1]});
        }
        return copy;
    }

    private static void simulateBattle(List<int[]> enemies) {
        int killCount = 0;

        while (!enemies.isEmpty()) {
            Set<String> targets = selectTargets(enemies);

            for (String s : targets) {
                String[] parts = s.split(",");
                int tx = Integer.parseInt(parts[0]);
                int ty = Integer.parseInt(parts[1]);

                enemies.removeIf(enemy -> enemy[0] == tx && enemy[1] == ty);
                killCount++;
            }

            moveEnemies(enemies);
        }

        res = Math.max(res, killCount);
    }

    private static Set<String> selectTargets(List<int[]> enemies) {
        Set<String> targets = new HashSet<>();

        for (int i = 0; i < 3; i++) {
            PriorityQueue<Node> pq = new PriorityQueue<>();

            for (int[] enemy : enemies) {
                int d = Math.abs(enemy[0] - n) + Math.abs(enemy[1] - archer[i]);
                if (d <= dist) {
                    pq.offer(new Node(enemy[0], enemy[1], d));
                }
            }

            if (!pq.isEmpty()) {
                Node target = pq.poll();
                targets.add(target.x + "," + target.y);
            }
        }

        return targets;
    }

    private static void moveEnemies(List<int[]> enemies) {
        for (int i = enemies.size() - 1; i >= 0; i--) {
            enemies.get(i)[0]++;
            if (enemies.get(i)[0] == n) {
                enemies.remove(i);
            }
        }
    }
}