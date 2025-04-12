import java.util.*;
class Solution {
    public int solution(String s) {
        StringBuilder sb = new StringBuilder(s);
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            if(check(sb.toString())) {
                count++;
            }
            sb.append(sb.charAt(0));
            sb.deleteCharAt(0);
        
        }
        return count;
    }
    
    public static boolean check(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            
            if(s.charAt(i) == '(' || s.charAt(i) == '['|| s.charAt(i) == '{') {
                stack.push(s.charAt(i));
                continue;
            }
            
            if(stack.isEmpty()) {
                return false;
            }
            if(stack.peek() == '(' && s.charAt(i) == ')') {
                stack.pop();
                continue;
            }
            if(stack.peek() == '{' && s.charAt(i) == '}') {
                stack.pop();
                continue;
            }
            if(stack.peek() == '[' && s.charAt(i) == ']') {
                stack.pop();
                continue;
            }
            

        }
        return stack.isEmpty();


    }
}
