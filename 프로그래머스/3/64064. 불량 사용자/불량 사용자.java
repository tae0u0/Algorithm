import java.util.HashSet;
import java.util.Set;

class Solution {
    Set<Integer> set = new HashSet<>();

    public int solution(String[] user_id, String[] banned_id) {
        dfs(0, 0, user_id, banned_id);
        return set.size();
    }

    private void dfs(int banIndex, int mask, String[] user_id, String[] banned_id) {
        if (banIndex == banned_id.length) {
            set.add(mask);
            return;
        }

        for (int i = 0; i < user_id.length; i++) {
            if ((mask & (1 << i)) != 0) continue;

            if (check(user_id[i], banned_id[banIndex])) {
                dfs(banIndex + 1, mask | (1 << i), user_id, banned_id);
            }
        }
    }

    private boolean check(String user, String ban) {
        if (user.length() != ban.length()) return false;

        for (int i = 0; i < user.length(); i++) {
            if (ban.charAt(i) == '*') continue;
            if (user.charAt(i) != ban.charAt(i)) return false;
        }

        return true;
    }
}