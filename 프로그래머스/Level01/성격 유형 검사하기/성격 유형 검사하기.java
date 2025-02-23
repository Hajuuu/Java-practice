import java.util.*;
class Solution {
    public String solution(String[] survey, int[] choices) {
        HashMap<Character, Integer> hm = new HashMap<>();
        hm.put('R', 0);
        hm.put('T', 0);
        hm.put('C', 0);
        hm.put('F', 0);
        hm.put('J', 0);
        hm.put('M', 0);
        hm.put('A', 0);
        hm.put('N', 0);
        for(int i = 0; i < choices.length; i++) {
            if(choices[i] < 4) {
                hm.replace(survey[i].charAt(0), hm.get(survey[i].charAt(0)) +Math.abs(4 - choices[i]));
            }
            if(choices[i] > 4) {
                hm.replace(survey[i].charAt(1), hm.get(survey[i].charAt(1)) + (choices[i] % 4));
            }
        }
        StringBuilder sb = new StringBuilder();
        if(hm.get('R') >= hm.get('T')) {
            sb.append('R');
        } else {
            sb.append('T');
        }
        if(hm.get('C') >= hm.get('F')) {
            sb.append('C');
        } else {
            sb.append('F');
        }
        if(hm.get('J') >= hm.get('M')) {
            sb.append('J');
        } else {
            sb.append('M');
        }
        if(hm.get('A') >= hm.get('N')) {
            sb.append('A');
        } else {
            sb.append('N');
        }
        return sb.toString();
    }
}
