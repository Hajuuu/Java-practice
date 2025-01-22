import java.util.*;
 
class Solution {
    public int[] solution(int N, int[] stages) {
        int[] count = new int[N + 2];
        for(int i = 0; i < stages.length; i++) {
            count[stages[i]]++;
        }
        Map<Integer, Double> map = new HashMap<>();
        
        int users = stages.length;
        for(int i = 1; i < count.length - 1; i++) {
            if(users == 0) {
                map.put(i, (double) 0);
                continue;
            }
            map.put(i, (double) count[i] / users);
            users -= count[i];
        }
        List<Integer> keySet = new ArrayList<>(map.keySet());
        keySet.sort((o1, o2) -> map.get(o2).compareTo(map.get(o1)));
        return keySet.stream().mapToInt(i -> i).toArray();
    }
}
