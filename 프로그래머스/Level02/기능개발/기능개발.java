import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i < progresses.length; i++) {
            int days = (100 - progresses[i]) / speeds[i];
            if((100 - progresses[i]) % speeds[i] > 0) {
                days++;
            }
            queue.offer(days);
        }
    
        int prev = queue.peek();
        int count = 0;
        List<Integer> deployments = new ArrayList<>();
        while(!queue.isEmpty()) {
            int progress = queue.peek();
            if(prev < progress) {
                deployments.add(count);
                count = 0;
                prev = progress;
            }
            count++;
            queue.poll();
        }
        
        deployments.add(count);
        int[] answer = new int[deployments.size()];
        for(int i = 0; i < deployments.size(); i++) {
            answer[i] = deployments.get(i);
        }
        return answer;
    }
}
