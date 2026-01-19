import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int s : scoville) {
            queue.offer(s);
        }
        
        int count = 0;
        
        while(queue.size() >= 2) {
            int sc1 = queue.poll();
            if(sc1 >= K) {
                return count;
            }
            int sc2 = queue.poll();
            queue.offer(sc1 + (sc2 * 2));
            count++;
        }
        
        if(queue.poll() >= K) {
            return count;
        }
        
        return -1;
    }
}
