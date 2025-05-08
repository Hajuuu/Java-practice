import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
            while(!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                answer[stack.peek()] = numbers[i];
                stack.pop();
            }
            stack.push(i);
        }
        
        while(!stack.isEmpty()) {
            answer[stack.pop()] = -1;
        }
        return answer;
    }
}
