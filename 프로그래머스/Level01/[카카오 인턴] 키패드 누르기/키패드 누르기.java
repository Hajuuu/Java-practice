import java.util.*;
class Solution {
    public String solution(int[] numbers, String hand) {
        HashMap<Integer, int[]> nums = new HashMap<>();
        nums.put(1, new int[] {0, 0});
        nums.put(2, new int[] {0, 1});
        nums.put(3, new int[] {0, 2});
        nums.put(4, new int[] {1, 0});
        nums.put(5, new int[] {1, 1});
        nums.put(6, new int[] {1, 2});
        nums.put(7, new int[] {2, 0});
        nums.put(8, new int[] {2, 1});
        nums.put(9, new int[] {2, 2});
        nums.put(0, new int[] {3, 1});
        int[] left = {3, 0};
        int[] right = {3, 2};
        
        HashMap<Integer, String> hm = new HashMap<>();
        hm.put(1, "L");
        hm.put(4, "L");
        hm.put(7, "L");
        hm.put(3, "R");
        hm.put(6, "R");
        hm.put(9, "R");
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < numbers.length; i++) {
            if(hm.containsKey(new Integer(numbers[i]))) {
                sb.append(hm.get(numbers[i]));
                if(hm.get(numbers[i]).equals("L")) {
                    left[0] = nums.get(numbers[i])[0];
                    left[1] = nums.get(numbers[i])[1];
                }
                if(hm.get(numbers[i]).equals("R")) {
                    right[0] = nums.get(numbers[i])[0];
                    right[1] = nums.get(numbers[i])[1];   
                }
                
                continue;
            }
            int[] now = nums.get(numbers[i]);
            if(Math.abs(now[0] - left[0]) + Math.abs(now[1] - left[1]) 
               < Math.abs(now[0] - right[0]) + Math.abs(now[1] - right[1])) {
                sb.append("L");
                left[0] = now[0];
                left[1] = now[1];
                continue;
              
            }
            if(Math.abs(now[0] - left[0]) + Math.abs(now[1] - left[1]) 
               == Math.abs(now[0] - right[0]) + Math.abs(now[1] - right[1])) {
                if(hand.equals("left")) {
                    sb.append("L");
                    left[0] = now[0];
                    left[1] = now[1];
                }
                if(hand.equals("right")) {
                    sb.append("R");
                    right[0] = now[0];
                    right[1] = now[1];
                }
                continue;
              
            }
            if(Math.abs(now[0] - left[0]) + Math.abs(now[1] - left[1]) 
               > Math.abs(now[0] - right[0]) + Math.abs(now[1] - right[1])) {
                sb.append("R");
                right[0] = now[0];
                right[1] = now[1];
            }
        }
        return sb.toString();
    }
}
