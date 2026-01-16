import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[prices.length];
        for(int i = 0; i < prices.length; i++) {
            while(!stack.isEmpty()) {
                if(prices[stack.peek()] > prices[i]) {
                    answer[stack.peek()] = i - stack.pop();
                    continue;
                }
                break;
            }
            stack.push(i);
        }
        
        while(!stack.isEmpty()) {
            answer[stack.peek()] = prices.length - stack.pop() - 1;
        }
        return answer;
    }
}
