import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        HashMap<String, Integer> names = new HashMap<>();
        
        HashMap<String, Set<String>> users = new HashMap<>();
        HashMap<String, Integer> count = new HashMap<>();
        for(int i = 0; i < id_list.length; i++) {
            users.put(id_list[i], new HashSet<>());
            names.put(id_list[i], i);
        }
        for(int i = 0; i < report.length; i++) {
            String[] user = report[i].split(" ");
            users.get(user[0]).add(user[1]);
        }
        users.forEach((key, value) -> {
            for(String u : value) {
                count.put(u, count.getOrDefault(u, 0) + 1);
            }
        });
        
        count.forEach((key, value) -> {
            if(value < k) {
                return;
            }
            users.forEach((key2, value2) -> {
                if(value2.contains(key)) {
                    answer[names.get(key2)]++;
                }
            });
        });
        return answer;
    }
}
