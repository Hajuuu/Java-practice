import java.util.*;
class Solution {
    public String solution(String number, int k) {
        Stack<Integer> stack = new Stack<>();
        int count = 0;
        for(int i = 0; i < number.length(); i++) {
            int now = number.charAt(i) - '0';
            while(!stack.isEmpty() && stack.peek() < now && count < k) {
                stack.pop();
                count++;
            }
            stack.push(now);
        }
        
        for(int i = 0; i < k - count; i++) {
            stack.pop();
        }
        
        StringBuilder sb = new StringBuilder();
        for(int num : stack) {
            sb.append(num);
        }
        
        return sb.toString();
    }
}
