import java.util.*;
class Solution {
    public int solution(int n) {
        Stack<Integer> stack = new Stack<>();
        while(n > 0) {
            stack.push(n % 3);
            n /= 3;
        }
        StringBuffer sb = new StringBuffer();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        String num = sb.reverse().toString();
        int answer = 0;
        for(int i = 0; i < num.length(); i++) {
            answer += Math.pow(3, num.length() - i - 1) * (num.charAt(i) - '0');
        }
        return answer;
    }
    
}
