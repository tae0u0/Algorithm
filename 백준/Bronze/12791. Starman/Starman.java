import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        String[] lines = init();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            List<String> li = new ArrayList<>();
            int cnt = 0;
            for (int i = 0; i < lines.length; i++) {
                int year = Integer.parseInt(lines[i].substring(0, 4));
                if(S <= year && E >= year) {
                    li.add(lines[i]);
                    cnt++;
                }
            }
            sb.append(cnt).append("\n");
            for(String str : li) {
                sb.append(str).append("\n");
            }
        }
        System.out.println(sb.toString());

    }

    private static String[] init() {
        return new String[]{
                "1967 DavidBowie",
                "1969 SpaceOddity",
                "1970 TheManWhoSoldTheWorld",
                "1971 HunkyDory",
                "1972 TheRiseAndFallOfZiggyStardustAndTheSpidersFromMars",
                "1973 AladdinSane",
                "1973 PinUps",
                "1974 DiamondDogs",
                "1975 YoungAmericans",
                "1976 StationToStation",
                "1977 Low",
                "1977 Heroes",
                "1979 Lodger",
                "1980 ScaryMonstersAndSuperCreeps",
                "1983 LetsDance",
                "1984 Tonight",
                "1987 NeverLetMeDown",
                "1993 BlackTieWhiteNoise",
                "1995 1.Outside",
                "1997 Earthling",
                "1999 Hours",
                "2002 Heathen",
                "2003 Reality",
                "2013 TheNextDay",
                "2016 BlackStar"
        };
    }
}