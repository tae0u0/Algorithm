import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        Map<String, Integer> totalPlays = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            totalPlays.put(genres[i], totalPlays.getOrDefault(genres[i], 0) + plays[i]);
        }

        Map<String, List<int[]>> songMap = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            songMap.computeIfAbsent(genres[i], k -> new ArrayList<>())
                   .add(new int[]{i, plays[i]});
        }

        List<Integer> answer = new ArrayList<>();

        totalPlays.entrySet().stream()
            .sorted((a, b) -> b.getValue() - a.getValue())
            .forEach(entry -> {
                String genre = entry.getKey();

                songMap.get(genre).stream()
                    .sorted((a, b) -> a[1] != b[1] ? b[1] - a[1] : a[0] - b[0])
                    .limit(2)
                    .forEach(song -> answer.add(song[0]));
            });

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}