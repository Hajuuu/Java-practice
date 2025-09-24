import java.util.*;
class Solution {
    static String[] userIds;
    static String[] bannedIds;
    static HashSet<HashSet<String>> result = new HashSet<>();
    public int solution(String[] user_id, String[] banned_id) {
        userIds = user_id;
        bannedIds = banned_id;
        
        dfs(0, new HashSet<>());
        return result.size();
    }
    
    public void dfs(int bannedIdx, HashSet<String> set) {
        if(bannedIdx == bannedIds.length) {
            result.add(set);
            return;
        }
        
        for(int i = 0; i < userIds.length; i++) {
            if(set.contains(userIds[i])) {
                continue;
            }
            if(check(userIds[i], bannedIds[bannedIdx])) {
                set.add(userIds[i]);
                dfs(bannedIdx + 1, new HashSet<>(set)); // result에 add가 될때 해시코드를 따라감
                set.remove(userIds[i]);
            }
        }
    }
    
    public boolean check(String userId, String bannedId) {
        if(userId.length() != bannedId.length()) {
            return false;
        }
        
        for(int i = 0; i < userId.length(); i++) {
            if(bannedId.charAt(i) != '*' && bannedId.charAt(i) != userId.charAt(i)) {
                return false;
            }
        }
        
        return true;
    }
}
