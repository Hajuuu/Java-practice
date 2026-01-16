import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> queue = new ArrayDeque<>();
        int totalWeight = 0;
        int time = 0;
        
        for(int truck : truck_weights) {
            while(true) {
                if(queue.isEmpty()) {
                    queue.offer(truck);
                    totalWeight += truck;
                    time++;
                    break;
                }
                if(queue.size() == bridge_length) {
                    totalWeight -= queue.poll();
                    continue;
                }
                if(totalWeight + truck > weight) {
                    queue.offer(0);
                    time++;
                    continue;
                }
                queue.offer(truck);
                totalWeight += truck;
                time++;
                break;
            }
        }
        
        return time + bridge_length;
    }
}
