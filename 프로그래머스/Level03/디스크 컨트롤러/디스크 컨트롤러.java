import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> {
            if(o1[2] == o2[2]) {
                if(o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
            return o1[2] - o2[2];
        });
        
        Arrays.sort(jobs, (o1, o2) -> {
            return o1[0] - o2[0];
        });
        
        
        int now = 0;
        int index = 0;
        int totalTime = 0;
        while(true) {
            if(index == jobs.length && queue.isEmpty()) {
                break;
            }
            
            
            for(int i = index; i < jobs.length; i++) {
                if(jobs[i][0] <= now) {
                    queue.offer(new int[] {i, jobs[i][0], jobs[i][1]});
                    index++;
                    continue;
                } 
                break;
            }
            if(queue.isEmpty()) {
                now = jobs[index][0];
                continue;
            }
            int[] job = queue.poll();       
            totalTime += now - job[1] + job[2];
            now += job[2];
            
        }
        
        return totalTime / jobs.length;
        
    }
}
