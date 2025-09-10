import java.io.*;
import java.util.*;

public class Main {
    static int r, c, k;
    static int[][] map;
    static int maxRow = 3, maxCol = 3;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken()) - 1;
        c = Integer.parseInt(st.nextToken()) - 1;
        k = Integer.parseInt(st.nextToken());

        map = new int[100][100];

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time = 0;
        while (time <= 100) {

            if (r < maxRow && c < maxCol && map[r][c] == k) {
                System.out.println(time);
                return;
            }

            time++;

            if (maxRow >= maxCol) {
                R();  // 행 연산
            } else {
                C();  // 열 연산
            }
        }

        System.out.println(-1);
    }

    private static void R() {
        int newMaxCol = 0;

        for (int i = 0; i < maxRow; i++) {
            // 각 숫자의 개수 세기 (0 제외)
            Map<Integer, Integer> countMap = new HashMap<>();
            for (int j = 0; j < maxCol; j++) {
                if (map[i][j] != 0) {
                    countMap.put(map[i][j], countMap.getOrDefault(map[i][j], 0) + 1);
                }
            }

            // (숫자, 개수) 쌍을 리스트로 만들어서 정렬
            List<int[]> pairs = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
                pairs.add(new int[]{entry.getKey(), entry.getValue()});
            }

            // 개수 오름차순, 개수가 같으면 숫자 오름차순
            pairs.sort((a, b) -> {
                if (a[1] != b[1]) return a[1] - b[1];  // 개수 비교
                return a[0] - b[0];  // 숫자 비교
            });

            // 기존 행을 0으로 초기화
            for (int j = 0; j < maxCol; j++) {
                map[i][j] = 0;
            }

            // 새로운 행 만들기
            int idx = 0;
            for (int[] pair : pairs) {
                map[i][idx++] = pair[0];  // 숫자
                map[i][idx++] = pair[1];  // 개수
                if (idx >= 100) break;  // 최대 100개까지만
            }

            newMaxCol = Math.max(newMaxCol, idx);
        }

        maxCol = newMaxCol;
    }

    private static void C() {
        int newMaxRow = 0;

        for (int j = 0; j < maxCol; j++) {
            // 각 숫자의 개수 세기 (0 제외)
            Map<Integer, Integer> countMap = new HashMap<>();
            for (int i = 0; i < maxRow; i++) {
                if (map[i][j] != 0) {
                    countMap.put(map[i][j], countMap.getOrDefault(map[i][j], 0) + 1);
                }
            }

            // (숫자, 개수) 쌍을 리스트로 만들어서 정렬
            List<int[]> pairs = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
                pairs.add(new int[]{entry.getKey(), entry.getValue()});
            }

            // 개수 오름차순, 개수가 같으면 숫자 오름차순
            pairs.sort((a, b) -> {
                if (a[1] != b[1]) return a[1] - b[1];  // 개수 비교
                return a[0] - b[0];  // 숫자 비교
            });

            // 기존 열을 0으로 초기화
            for (int i = 0; i < maxRow; i++) {
                map[i][j] = 0;
            }

            // 새로운 열 만들기
            int idx = 0;
            for (int[] pair : pairs) {
                map[idx++][j] = pair[0];  // 숫자
                map[idx++][j] = pair[1];  // 개수
                if (idx >= 100) break;
            }

            newMaxRow = Math.max(newMaxRow, idx);
        }

        maxRow = newMaxRow;
    }
}