import java.util.*;
class Solution {
    static List<String> alphabets;
    static int count = 0;
    static boolean find = false;
    public int solution(String word) {
        alphabets = List.of("A", "E", "I", "O", "U");
        dfs(word, "");
        return count;
    }
    
    
    public void dfs(String word, String now) {
        if (now.equals(word)) {
            find = true;
            return;
        }
        if(now.length() > 4) {
            return;
        }
        for (String alphabet : alphabets) {
            if(!find) {
                count++;
                dfs(word, now + alphabet);
            }
            
        }
    }
}
