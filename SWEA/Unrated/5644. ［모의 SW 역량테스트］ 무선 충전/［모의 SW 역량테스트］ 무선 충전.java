import java.util.*;
import java.io.*;

public class Solution {
    private static int T, M, A;
    private static int ax, ay, bx, by;
    private final static int SIZE = 10;
    private static int[] moveA, moveB;
    private static BC[] bcArr;
    private static BufferedReader br;
    private static int[] dx = {0, 0, 1, 0, -1}; // X상우하좌
    private static int[] dy = {0, -1, 0, 1, 0}; // X상우하좌
    private static List<Integer> availableA = new ArrayList<>(), availableB = new ArrayList<>();

    private static class BC {
        int x, y, c, p;

        public BC(int x, int y, int c, int p) {
            this.x = x;
            this.y = y;
            this.c = c;
            this.p = p;
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            init();
            int energySum = getEnergy();
            for (int i = 0; i < M; i++) {
                ax += dx[moveA[i]];
                ay += dy[moveA[i]];
                bx += dx[moveB[i]];
                by += dy[moveB[i]];
                energySum += getEnergy();
            }
            sb.append("#").append(tc).append(" ").append(energySum).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static int getEnergy(){

        for (int i = 0; i <bcArr.length; i++) {
            BC bc = bcArr[i];
            if(Math.abs(bc.y - ay) + Math.abs(bc.x - ax) <= bc.c) {
                availableA.add(i);
            }
            if(Math.abs(bc.y - by) + Math.abs(bc.x - bx) <= bc.c) {
                availableB.add(i);
            }
        }
        int rst = 0;
        if(!availableA.isEmpty() && availableB.isEmpty()) {
            for (int index : availableA) {
                BC bc = bcArr[index];
                rst = Math.max(bc.p, rst);
            }
        };
        if(availableA.isEmpty() && !availableB.isEmpty()) {
            for (int index : availableB) {
                BC bc = bcArr[index];
                rst = Math.max(bc.p, rst);
            }
        };
        if(!availableA.isEmpty() && !availableB.isEmpty()) {
            for (int i = 0; i < availableA.size(); i++) {
                for (int j = 0; j < availableB.size(); j++) {
                    int indexA = availableA.get(i);
                    int indexB = availableB.get(j);
                    if(indexA == indexB) rst = Math.max(rst, bcArr[indexB].p);
                    else {
                        rst = Math.max(bcArr[indexA].p + bcArr[indexB].p, rst);
                    }
                }
            }
        }
        availableA.clear();
        availableB.clear();
        return rst;
    }

    private static void init() throws IOException {
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());

        moveA = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        moveB = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        bcArr = new BC[A];
        for (int i = 0; i < A; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            bcArr[i] = new BC(x, y, c, p);
        }
        ax = 1;
        ay = 1;
        bx = 10;
        by = 10;
    }
}
