import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
    static int minDiff;
 
    static int N;
    static int synergies[][];
    static boolean used[];
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
 
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; ++test_case)
        {
            minDiff = Integer.MAX_VALUE;
 
            N = Integer.parseInt(br.readLine());
            synergies = new int[N + 1][N + 1];
            used = new boolean[N + 1];
 
            for(int i = 1; i <= N; ++i)
            {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
 
                for(int j = 1; j <= N; ++j)
                {
                    synergies[i][j] = Integer.parseInt(st.nextToken());
                }
            }
 
            DFS(1, 0);
 
            sb.append("#" + test_case + " " + minDiff + "\n");
        } // test_case
        System.out.println(sb);
    }
 
    static public void DFS(int depth, int cnt)
    {
        if(minDiff == 0)
        {
            return;
        }
 
        if(depth > N)
        {
            return;
        }
 
        if(cnt == N / 2)
        {
            int score1 = 0;
            int score2 = 0;
 
            for(int i = 1; i <= N; ++i)
            {
                for(int j = 1; j <= N; ++j)
                {
                    if(used[i] && used[j])
                    {
                        score1 += synergies[i][j];
                    }
                    else if(!used[i] && !used[j])
                    {
                        score2 += synergies[i][j];
                    }
                }
            }
 
            minDiff = Math.min(minDiff, Math.abs(score1 - score2));
            return;
        }
 
        used[depth] = true;
        DFS(depth + 1, cnt + 1);
 
        used[depth] = false;
        DFS(depth + 1, cnt);
 
    }
}