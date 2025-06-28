import java.util.*;
class Solution {
    static boolean[] visited;
    static Set<Set<String>> answer;
    static Set<String> now;
    public int solution(String[] user_id, String[] banned_id) {
        visited = new boolean[user_id.length];
        answer = new HashSet<>();
        now = new HashSet<>();
        dfs(user_id, banned_id, 0);
        return answer.size();
    }
    
    public void dfs(String[] user_id, String[] banned_id, int depth) {
        if(depth == banned_id.length) {
            answer.add(new HashSet<>(now));
            return;
        }
        
        for(int i = 0; i < user_id.length; i++) {
            if(!visited[i]) {
                
                if(checkId(user_id[i], banned_id[depth])) {
                    visited[i] = true;
                    now.add(user_id[i]);
                    dfs(user_id, banned_id, depth + 1);
                    now.remove(user_id[i]);
                    visited[i] = false;
                }
               
            }
        }
    }
    
    public boolean checkId(String id, String banned) {
        if(id.length() != banned.length()) {
            return false;
        }
        
        for(int i = 0; i < id.length(); i++) {
            if(banned.charAt(i) != '*' && id.charAt(i) != banned.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
