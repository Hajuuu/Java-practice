import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        PriorityQueue<Integer> priority = new PriorityQueue<>(Collections.reverseOrder());
        Queue<int[]> queue = new ArrayDeque<>();
        int answer = 0;
        
        
        for(int i = 0; i < priorities.length; i++) {
            priority.offer(priorities[i]);
            queue.offer(new int[] {i, priorities[i]});
        }
        
        while(!queue.isEmpty()) {
            int[] now = queue.peek();
            if(priority.peek() == now[1]) {
                answer++;
                if(location == now[0]) {
                    return answer;
                }
                queue.poll();
                priority.poll();
                continue;
            }
            queue.offer(queue.poll());
        }
        
        return answer;
    }
}
