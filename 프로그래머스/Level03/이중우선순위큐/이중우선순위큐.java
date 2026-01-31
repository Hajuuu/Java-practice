import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> max = new PriorityQueue<>((o1, o2) -> o2 - o1);
        PriorityQueue<Integer> min = new PriorityQueue<>();
        
        for(String op : operations) {
            String[] input = op.split(" ");
            if(input[0].equals("I")) {
                max.offer(Integer.parseInt(input[1]));
                min.offer(Integer.parseInt(input[1]));
                continue;
            }
            
            if(Integer.parseInt(input[1]) == 1) {
                if(!max.isEmpty()) {
                    min.remove(max.poll());
                }
                continue;
            }
            
            if(!min.isEmpty()) {
                max.remove(min.poll());
            }
        }
        
        int[] answer = new int[2];
        if(!max.isEmpty()) {
            answer[0] = max.poll();
        }
        
        if(!min.isEmpty()) {
            answer[1] = min.poll();
        }
        
        return answer;
    }
}
