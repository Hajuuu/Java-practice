import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Deque<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i < arr.length; i++) {
            if(queue.size() > 0 && queue.getLast() == arr[i]) {
                continue;
            }
            queue.offer(arr[i]);
        }
        int length = queue.size();
        int[] answer = new int[length];
        for(int i = 0; i < length; i++) {
            answer[i] = queue.poll();
        }
        return answer;
    }
}
