import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        
        int currentTime = 0;
        int index = 0;
        int totalTime = 0;
        int count = 0;
        while(count < jobs.length) {
            while(index < jobs.length && jobs[index][0] <= currentTime) {
                queue.offer(jobs[index]);
                index++;
            }
            
            if(queue.isEmpty()) {
                currentTime = jobs[index][0];
                continue;
            }
            int[] job = queue.poll();
            currentTime += job[1];
            totalTime += currentTime - job[0];
            count++;
        }
         
        return totalTime / jobs.length;
    }
}
