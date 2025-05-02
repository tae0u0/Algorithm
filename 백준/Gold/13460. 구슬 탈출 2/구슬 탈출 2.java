import java.util.*;

public class Main {
    static int N, M;
    static char[][] board;
    static boolean[][][][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int holeY, holeX;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        board = new char[N][M];
        visited = new boolean[N][M][N][M];

        int ry = 0, rx = 0, by = 0, bx = 0;

        for (int i = 0; i < N; i++) {
            String line = sc.next();
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j);
                if (board[i][j] == 'R') {
                    ry = i;
                    rx = j;
                    board[i][j] = '.';
                } else if (board[i][j] == 'B') {
                    by = i;
                    bx = j;
                    board[i][j] = '.';
                } else if (board[i][j] == 'O') {
                    holeY = i;
                    holeX = j;
                }
            }
        }

        int result = bfs(ry, rx, by, bx);
        System.out.println(result);
    }

    static int bfs(int ry, int rx, int by, int bx) {
        Queue<State> queue = new LinkedList<>();
        queue.add(new State(ry, rx, by, bx, 0));
        visited[ry][rx][by][bx] = true;

        while (!queue.isEmpty()) {
            State cur = queue.poll();

            if (cur.moveCount >= 10) return -1;

            for (int dir = 0; dir < 4; dir++) {
                int[] nextRed = move(cur.ry, cur.rx, dy[dir], dx[dir]);
                int[] nextBlue = move(cur.by, cur.bx, dy[dir], dx[dir]);

                int nry = nextRed[0], nrx = nextRed[1], rDist = nextRed[2];
                int nby = nextBlue[0], nbx = nextBlue[1], bDist = nextBlue[2];

                if (nby == holeY && nbx == holeX) continue;

                if (nry == holeY && nrx == holeX) return cur.moveCount + 1;

                if (nry == nby && nrx == nbx) {
                    if (rDist > bDist) {
                        nry -= dy[dir];
                        nrx -= dx[dir];
                    } else {
                        nby -= dy[dir];
                        nbx -= dx[dir];
                    }
                }

                if (!visited[nry][nrx][nby][nbx]) {
                    visited[nry][nrx][nby][nbx] = true;
                    queue.add(new State(nry, nrx, nby, nbx, cur.moveCount + 1));
                }
            }
        }

        return -1;
    }

    static int[] move(int y, int x, int dy, int dx) {
        int dist = 0;
        while (true) {
            if (board[y + dy][x + dx] == '#') break;
            y += dy;
            x += dx;
            dist++;
            if (board[y][x] == 'O') break;
        }
        return new int[]{y, x, dist};
    }

    static class State {
        int ry, rx, by, bx, moveCount;

        State(int ry, int rx, int by, int bx, int moveCount) {
            this.ry = ry;
            this.rx = rx;
            this.by = by;
            this.bx = bx;
            this.moveCount = moveCount;
        }
    }
}
