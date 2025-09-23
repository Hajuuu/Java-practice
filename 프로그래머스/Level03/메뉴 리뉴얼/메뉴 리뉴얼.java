import java.util.*;
class Solution {
    static Map<String, Integer> menus;
    static List<Integer> lengths;
    public String[] solution(String[] orders, int[] course) {
        menus = new HashMap<>();
        lengths = new ArrayList<>();
        for(int i : course) {
            lengths.add(i);
        }
        
        for(int i = 0; i < orders.length; i++) {
            char[] chars = orders[i].toCharArray();
            Arrays.sort(chars);
            orders[i] = new String(chars);
        }
        
        for(String order : orders) {
            combi(order, "", 0);
        }
        
        List<Map.Entry<String,Integer>> entryList = new ArrayList<>(menus.entrySet());
        
        entryList.sort((e1, e2) -> {
            if(e1.getKey().length() == e2.getKey().length()) {
                return e2.getValue() - e1.getValue();
            }
            return e1.getKey().length() - e2.getKey().length();
        });
        List<String> answer = new ArrayList<>();
        for(int i : course) {
            int max = 0;
            for(Map.Entry<String, Integer> entry : entryList) {
                if((entry.getKey().length() != i) || entry.getValue() < 2) {
                    continue;
                }
                if(entry.getKey().length() == i) {
                    if(max < entry.getValue() || (max != 0 && max == entry.getValue())) {
                        answer.add(entry.getKey());
                        max = entry.getValue();
                    } else {
                        break;
                    }
                }
            }
        }
        Collections.sort(answer);
        return answer.toArray(new String[0]);
    }
    
    public void combi(String order, String menu, int idx) {
        if(lengths.contains(menu.length())) {
            menus.put(menu, menus.getOrDefault(menu, 0) + 1);
        }
        for(int i = idx; i < order.length(); i++) {
            combi(order, menu + order.charAt(i), i + 1);
        }
    }
}
