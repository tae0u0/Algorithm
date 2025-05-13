import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {
    static int N;
    static List<Ant> houses = new ArrayList<>();
    static List<Integer> ants = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N =  Integer.parseInt(br.readLine());

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
                int time = reconnoitre(input);
                bw.write(time + "\n");
            }
        }

        bw.flush();
        bw.close();

    }

    // 100번 호출 마을 건성
    private static void townInit(String[] input){
        int num = Integer.parseInt(input[1]);
        houses.add(new Ant(0, 0));

        for (int i = 1; i <= num; i++) {
            houses.add(new Ant(i, Integer.parseInt(input[i + 1])));
        }
    }

    // 200번 호출 개미집 건설
    private static void buildHouse(String[] input) {
        Ant last_house = houses.get(houses.size() - 1);
        houses.add(new Ant(last_house.index + 1, Integer.parseInt(input[1])));
    }

    // 300번 호출 개미집 철거
    private static void demolishHouse(String[] input) {
        int index = Integer.parseInt(input[1]);
        houses.remove(new Ant(index, 0));
    }

    // 400번 호출 개미집 정찰
    private static int reconnoitre(String[] input) {
        int num = Integer.parseInt(input[1]);
        return recursion(0, 0, num);
    }

    private static int recursion(int level, int index, int num) {
        if(level == num) {
            int result = -1;
            List<Integer> houses_pos = new ArrayList<>();
            List<Integer> ants_pos = new ArrayList<>();
            boolean[] visited = new boolean[houses.size()];
            visited[0] = true;

            for (int i = 0; i < houses.size(); i++) {
                houses_pos.add(houses.get(i).pos);
            }

            for (int i = 0; i < level; i++) {
                ants_pos.add(ants.get(i));
            }

            boolean flag = true;
            while(flag) {
                result++;

                for (int i = ants_pos.size()-1; i >= 0; i--) {
                    int ant_pos = ants_pos.get(i);
                    if(houses_pos.contains(ant_pos)){
                        int house_seq = houses_pos.indexOf(ant_pos);
                        if(visited[house_seq]) {
                            flag = false;
                            break;
                        }
                        visited[house_seq] = true;
                    }

                    ants_pos.set(i, ant_pos + 1);

                    // 마지막 개미집에 도착했다면, 개미 삭제
                    if(ant_pos+1 > houses_pos.get(houses.size()-1)){
                        ants_pos.remove(i);
                    }

                }

                // 종료 조건 1 전진할 수 있는 개미가 없다면
                if(ants_pos.isEmpty())
                    flag = false;

                // 종료 조건 2 모든 개미집을 방문했다면
                boolean allVisited = true;
                for (boolean v : visited) {
                    if (!v) {
                        allVisited = false;
                        break;
                    }
                }
                if (allVisited)
                    break;
            }

            for (boolean visit : visited) {
                if(!visit){
                    return Integer.MAX_VALUE;
                }
            }

            return result;
        }

        int result = Integer.MAX_VALUE;
        for (int i = index; i < houses.size(); i++) {
            ants.add(houses.get(i).pos);
            result = Integer.min(recursion(level + 1, i + 1, num), result);
            ants.remove(ants.size() - 1);
        }

        return result;
    }

    static class Ant {
        int index, pos;

        public Ant(int index, int pos) {
            this.index = index;
            this.pos = pos;
        }

        @Override
        public boolean equals(Object o) {
            Ant ant = (Ant) o;
            return this.index == ant.index;
        }

        @Override
        public int hashCode() {
            return Objects.hash(index);
        }
    }
}