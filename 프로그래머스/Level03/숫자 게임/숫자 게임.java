import java.util.*;
class Solution {
    public int solution(int[] A, int[] B) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> (o2 - o1));
        List<Integer> nums = new ArrayList<>();
        for(int i = 0; i < A.length; i++) {
            queue.offer(A[i]);
            nums.add(B[i]);
        }
        Collections.sort(nums, Collections.reverseOrder());
        
        int score = 0;
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            if(cur < nums.get(0)) {
                nums.remove(0);
                score++;
            } else {
                nums.remove(nums.size() - 1);
            }
        }
        return score;
    }
}
