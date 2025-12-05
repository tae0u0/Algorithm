import java.io.*;

public class Main {
    static final int SIZE = 1 << 16; // 64KB 버퍼
    static byte[] buffer = new byte[SIZE];
    static int idx = 0, len = 0;

    static int read() throws Exception {
        if (idx >= len) {
            len = System.in.read(buffer);
            idx = 0;
            if (len <= 0) return -1;
        }
        return buffer[idx++];
    }

    static int nextInt() throws Exception {
        int c, sign = 1, n = 0;

        // skip whitespace
        do c = read(); while (c <= ' ');

        // sign
        if (c == '-') { sign = -1; c = read(); }

        // number
        while (c > ' ') {
            n = n * 10 + (c - '0');
            c = read();
        }
        return n * sign;
    }

    public static void main(String[] args) throws Exception {
        int N = nextInt();

        int[] minPrev = new int[3];
        int[] maxPrev = new int[3];
        int[] minNow = new int[3];
        int[] maxNow = new int[3];

        for (int i = 0; i < 3; i++) {
            int v = nextInt();
            minPrev[i] = maxPrev[i] = v;
        }

        for (int i = 1; i < N; i++) {
            int a = nextInt(), b = nextInt(), c = nextInt();

            maxNow[0] = a + Math.max(maxPrev[0], maxPrev[1]);
            maxNow[1] = b + Math.max(Math.max(maxPrev[0], maxPrev[1]), maxPrev[2]);
            maxNow[2] = c + Math.max(maxPrev[1], maxPrev[2]);

            minNow[0] = a + Math.min(minPrev[0], minPrev[1]);
            minNow[1] = b + Math.min(Math.min(minPrev[0], minPrev[1]), minPrev[2]);
            minNow[2] = c + Math.min(minPrev[1], minPrev[2]);

            System.arraycopy(maxNow, 0, maxPrev, 0, 3);
            System.arraycopy(minNow, 0, minPrev, 0, 3);
        }

        int maxResult = Math.max(maxPrev[0], Math.max(maxPrev[1], maxPrev[2]));
        int minResult = Math.min(minPrev[0], Math.min(minPrev[1], minPrev[2]));

        System.out.println(maxResult + " " + minResult);
    }
}
