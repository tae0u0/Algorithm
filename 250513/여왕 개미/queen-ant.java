import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static List<Ant> houses = new ArrayList<>();
    static List<Integer> ants = new ArrayList<>();
    static int minResult = Integer.MAX_VALUE;
    static int house_index = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            String cmd = input[0];
            if (cmd.equals("100")) {
                townInit(input);
            } else if (cmd.equals("200")) {
                buildHouse(input);
            } else if (cmd.equals("300")) {
                demolishHouse(input);
            } else if (cmd.equals("400")) {
                minResult = Integer.MAX_VALUE; // 매 정찰마다 초기화
                int time = reconnoitre(input);
                bw.write(time + "\n");
            }
        }

        bw.flush();
        bw.close();
    }

    private static void townInit(String[] input) {
        houses.add(new Ant(0, 0)); // dummy
        int num = Integer.parseInt(input[1]);
        for (int i = 1; i <= num; i++) {
            houses.add(new Ant(i, Integer.parseInt(input[i + 1])));
        }
        house_index += num;
    }

    private static void buildHouse(String[] input) {
        houses.add(new Ant(house_index + 1, Integer.parseInt(input[1])));
    }

    private static void demolishHouse(String[] input) {
        int index = Integer.parseInt(input[1]);
        houses.remove(new Ant(index, 0));
    }

    private static int reconnoitre(String[] input) {
        int num = Integer.parseInt(input[1]);
        return recursion(0, 1, num); // index 1부터 시작
    }

    private static int recursion(int level, int index, int num) {
        if (level == num) {
            int result = simulate();

            if (result < minResult) {
                minResult = result;
            }

            return result;
        }

        int result = Integer.MAX_VALUE;
        for (int i = index; i < houses.size(); i++) {
            ants.add(houses.get(i).pos);
            result = Math.min(result, recursion(level + 1, i + 1, num));
            ants.remove(ants.size() - 1);
        }

        return result;
    }

    private static int simulate() {
        List<Integer> ants_pos = new ArrayList<>(ants);
        Map<Integer, Integer> houseMap = new HashMap<>();
        for (int i = 0; i < houses.size(); i++) {
            houseMap.put(houses.get(i).pos, i);
        }

        boolean[] visited = new boolean[houses.size()];
        visited[0] = true; // 여왕 개미 집은 항상 true~

        int result = -1;
        while (true) {
            result++;

            // 개미 이동 및 충돌 확인
            for (int i = ants_pos.size() - 1; i >= 0; i--) {
                int ant_pos = ants_pos.get(i);

                if (houseMap.containsKey(ant_pos)) {
                    int houseIndex = houseMap.get(ant_pos);
                    if (visited[houseIndex]) {
                        return Integer.MAX_VALUE; // 충돌
                    }
                    visited[houseIndex] = true;
                }

                // 이동
                ants_pos.set(i, ant_pos + 1);

                // 범위 벗어나면 제거
                if (ant_pos + 1 > houses.get(houses.size() - 1).pos) {
                    ants_pos.remove(i);
                }
            }

            // 개미가 모두 사라졌거나 모든 집 방문했으면 종료
            if (ants_pos.isEmpty() || allVisited(visited)) {
                break;
            }

            // 어차피 최소가 아니야~
            if (result >= minResult) {
                return Integer.MAX_VALUE;
            }
        }

        return allVisited(visited) ? result : Integer.MAX_VALUE;
    }

    private static boolean allVisited(boolean[] visited) {
        for (boolean v : visited) {
            if (!v) return false;
        }
        return true;
    }

    static class Ant {
        int index, pos;

        public Ant(int index, int pos) {
            this.index = index;
            this.pos = pos;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Ant ant = (Ant) o;
            return index == ant.index;
        }

        @Override
        public int hashCode() {
            return Objects.hash(index);
        }
    }
}
