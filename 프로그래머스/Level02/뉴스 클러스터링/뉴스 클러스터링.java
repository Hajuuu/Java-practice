import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        ArrayList<String> s1 = new ArrayList<>();
        ArrayList<String> s2 = new ArrayList<>();
        for(int i = 0; i < str1.length() - 1; i++) {
            if(str1.charAt(i) < 'a' || str1.charAt(i) > 'z' || str1.charAt(i + 1) < 'a' || str1.charAt(i + 1) > 'z') {
                continue;
            }
            s1.add(String.valueOf(str1.charAt(i)) + String.valueOf(str1.charAt(i + 1)));
        }
        for(int i = 0; i < str2.length() - 1; i++) {
            if(str2.charAt(i) < 'a' || str2.charAt(i) > 'z' || str2.charAt(i + 1) < 'a' || str2.charAt(i + 1) > 'z') {
                continue;
            }
            s2.add(String.valueOf(str2.charAt(i)) + String.valueOf(str2.charAt(i + 1)));
        }
        
        ArrayList<String> inter = new ArrayList<>();
        ArrayList<String> union = new ArrayList<>(); 
        
        for(int i = 0; i < s1.size(); i++) {
            if(s2.remove(s1.get(i))) {
                inter.add(s1.get(i));
            }
            union.add(s1.get(i));
        }
        
        for(int i = 0; i < s2.size(); i++) {
            union.add(s2.get(i));
        }
        
        if(union.size() == 0) {
            return 65536;
        }
        double j = (double) inter.size() / union.size();
        
        int answer = (int) (j * 65536);
        return answer;
    }
    

}
