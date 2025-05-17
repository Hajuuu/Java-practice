import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0; i < works.length; i++) {
            queue.offer(works[i]);
        }
        
        while(n > 0 && !queue.isEmpty()) {
            int max = queue.poll();
            if(max == 0) {
                return 0;
            }
            queue.offer(max - 1);
            n--;
        }
        
        while(!queue.isEmpty()) {
            int work = queue.poll();
            answer += work * work;
        }
        return answer;
    }
}
