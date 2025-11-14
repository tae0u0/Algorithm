import java.util.Scanner;
import java.util.Arrays;


public class Main {
    static class Bucket implements Comparable<Bucket> {
        int pos;
        int candy;

        public Bucket(int pos, int candy) {
            this.pos = pos;
            this.candy = candy;
        }

        @Override
        public int compareTo(Bucket o) {
            return this.pos - o.pos;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        Bucket[] buckets = new Bucket[n];
        for (int i = 0; i < n; i++) {
            int candy = sc.nextInt();
            int position = sc.nextInt();
            buckets[i] = new Bucket(position, candy);
        }

        Arrays.sort(buckets);
        int maxNum = Integer.MIN_VALUE;
        for(int i = k; i < buckets[n-1].pos; i++) {
            int prev = i - k;
            int post = i + k;
            int cnt = 0;
            for(int j = 0; j < n; j++) {
                if(buckets[j].pos >= prev && buckets[j].pos <= post) {
                    cnt += buckets[j].candy;
                }
            }
            maxNum = Math.max(maxNum, cnt);
        }
        System.out.print(maxNum);
    }
}