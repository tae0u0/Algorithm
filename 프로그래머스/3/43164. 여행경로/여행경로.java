import java.util.*;

class Solution {
    HashMap<String, PriorityQueue<String>> ticketMap;
    List<String> route = new LinkedList<>();

    public String[] solution(String[][] tickets) {
        ticketMap = new HashMap<>();
        for (String[] t : tickets) {
            ticketMap.computeIfAbsent(t[0], k -> new PriorityQueue<>()).add(t[1]);
        }
        dfs("ICN");
        Collections.reverse(route);
        return route.toArray(new String[0]);
    }

    private void dfs(String airport) {
        PriorityQueue<String> pq = ticketMap.get(airport);
        while (pq != null && !pq.isEmpty()) {
            dfs(pq.poll());
        }
        route.add(airport); 
    }
}