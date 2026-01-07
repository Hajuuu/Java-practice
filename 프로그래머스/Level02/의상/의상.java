import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> cloth = new HashMap<>();
        for(String[] c : clothes) {
            cloth.put(c[1], cloth.getOrDefault(c[1], 0) + 1);
        }
        
        int answer = 1;
        for(String key : cloth.keySet()) {
            answer *= cloth.get(key) + 1;
        }
        return answer - 1;
    }
}
