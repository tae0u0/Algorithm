import java.util.*;
import java.io.*;

public class Main {

    static int N, M, K;
    static int[][] A;                    
    static int[][] nutr;                 
    static Deque<Integer>[][] forest;    

    static final int[][] DIR = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1},           {0, 1},
            {1, -1},  {1, 0},  {1, 1}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        A    = new int[N][N];
        nutr = new int[N][N];
        forest = new ArrayDeque[N][N];

        for (int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < N; x++) {
                A[y][x] = Integer.parseInt(st.nextToken());
                nutr[y][x] = 5;               
                forest[y][x] = new ArrayDeque<>();
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int y   = Integer.parseInt(st.nextToken()) - 1;
            int x   = Integer.parseInt(st.nextToken()) - 1;
            int age = Integer.parseInt(st.nextToken());
            forest[y][x].offer(age);       
        }

        for (int year = 0; year < K; year++) {
            springAndSummer();
            autumn();
            winter();
        }

        System.out.println(countTrees());
    }

    static void springAndSummer() {
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (forest[y][x].isEmpty()) continue;

                Deque<Integer> next = new ArrayDeque<>();
                int dead = 0;

                while (!forest[y][x].isEmpty()) {
                    int age = forest[y][x].pollFirst();

                    if (nutr[y][x] >= age) {
                        nutr[y][x] -= age;
                        next.offerLast(age + 1);
                    } else {
                        dead += age / 2;
                    }
                }
                nutr[y][x] += dead;
                forest[y][x] = next;
            }
        }
    }

    static void autumn() {
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (forest[y][x].isEmpty()) continue;

                for (int age : forest[y][x]) {
                    if (age % 5 != 0) continue;
                    for (int[] d : DIR) {
                        int ny = y + d[0];
                        int nx = x + d[1];
                        if (ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
                        forest[ny][nx].offerFirst(1);
                    }
                }
            }
        }
    }

    static void winter() {
        for (int y = 0; y < N; y++)
            for (int x = 0; x < N; x++)
                nutr[y][x] += A[y][x];
    }

    static int countTrees() {
        int sum = 0;
        for (int y = 0; y < N; y++)
            for (int x = 0; x < N; x++)
                sum += forest[y][x].size();
        return sum;
    }
}
