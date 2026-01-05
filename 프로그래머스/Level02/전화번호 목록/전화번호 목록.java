import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        Set<String> numbers = new HashSet<>();
        for(String p : phone_book) {
            numbers.add(p);
        }
        
        for(int i = 0; i < phone_book.length; i++) {
            numbers.remove(phone_book[i]);
            String num = "";
            for(int j = 0; j < phone_book[i].length(); j++) {
                num += phone_book[i].charAt(j);
                if(numbers.contains(num)) {
                    return false;
                }
            }
            numbers.add(phone_book[i]);
        }
        return true;
    }
}
