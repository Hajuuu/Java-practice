import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        List<String> nums = new ArrayList<>();
        
        for(int n : numbers) {
            nums.add(String.valueOf(n));
        }
        
        nums.sort((o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        
        String answer = "";
        for(String n : nums) {
            answer += n;
        }
        
        if(answer.charAt(0) == '0') {
            return "0";
        }
        
        return answer;
    }
}
