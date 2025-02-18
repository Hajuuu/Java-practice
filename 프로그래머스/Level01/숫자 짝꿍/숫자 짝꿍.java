import java.util.*;
class Solution {
    public String solution(String X, String Y) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        char[] x = X.toCharArray();
        char[] y = Y.toCharArray();
        
        HashMap<Integer, Integer> xCount = new HashMap<>();
        HashMap<Integer, Integer> yCount = new HashMap<>();
        
        for(char c : x) {
            xCount.put(c - '0', xCount.getOrDefault(c - '0', 0) + 1);
        }
        
        for(char c : y) {
            yCount.put(c - '0', yCount.getOrDefault(c - '0', 0) + 1);
        }
        
        for(int i = 0; i < 10; i++) {
            int min = Math.min(xCount.getOrDefault(i, 0), yCount.getOrDefault(i, 0));
            for(int j = 0; j < min; j++) {
                pq.offer(i);
            }
        }
        
        if(pq.size() == 0) {
            return "-1";
        }
        if(pq.peek() == 0) {
            return "0";
        }
        
       
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
            sb.append(pq.poll());
        }
        return sb.toString();
    }
}
