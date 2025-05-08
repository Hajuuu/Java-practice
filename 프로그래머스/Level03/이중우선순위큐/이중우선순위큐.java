import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> min = new PriorityQueue<>();
        int[] answer = new int[2];
        StringTokenizer st;
        for(int i = 0; i < operations.length; i++) {
            st = new StringTokenizer(operations[i]);
            String operation = st.nextToken();
            if(operation.equals("I")) {
                int num = Integer.parseInt(st.nextToken());
                max.offer(num);
                min.offer(num);
                continue;
            }
            if(operation.equals("D")) {
                if(Integer.parseInt(st.nextToken()) == 1 && !max.isEmpty()) {
                    min.remove(max.poll());
                    continue;
                } 
                if(!min.isEmpty()) {
                    max.remove(min.poll());
                }           
            }
        }
        if(max.isEmpty() && min.isEmpty()) {
            return answer;
        }
        answer[0] = max.poll();
        answer[1] = min.poll();
        return answer;
    }
}

