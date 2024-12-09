import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        int index = 0;
        String[] word = s.split("");
        for(int i = 0; i < s.length(); i++) {
            if(!word[i].isBlank()) {
                if(index % 2 == 0) {
                    answer += word[i].toUpperCase();
                    index++;
                } else {
                    answer += word[i].toLowerCase();
                    index++;
                }
            } else {
                answer += " ";
                index = 0;
            }
        }
        return answer;
    }
}
