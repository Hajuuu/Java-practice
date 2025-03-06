import java.util.*;
class Solution {
    public String solution(String new_id) {
        List<Character> list = new ArrayList<>();
        for(int i = 0; i < new_id.length(); i++) {
            if(Character.isUpperCase(new_id.charAt(i))) {
                list.add(Character.toLowerCase(new_id.charAt(i)));
                continue;
            }
            if(String.valueOf(new_id.charAt(i)).matches("[a-z0-9-_]")) {
                list.add(new_id.charAt(i));
                continue;
            }
            if(list.size() > 0 && list.get(list.size() - 1) != '.' && new_id.charAt(i) == '.') {
                list.add(new_id.charAt(i));
                continue;
            }
        }
        
        if(list.size() == 0) {
            list.add('a');
        }
        while(list.size() > 15) {
            list.remove(list.size() - 1);
        }
        if(list.get(list.size() - 1) == '.') {
            list.remove(list.size() - 1);
        }
        if(list.get(0) == '.') {
            list.remove(0);
        }
        while(list.size() < 3) {
            list.add(list.get(list.size() - 1));
        }
        StringBuilder sb = new StringBuilder();
        for(char c : list) {
            sb.append(c);
        }
        return sb.toString();
    }
}
