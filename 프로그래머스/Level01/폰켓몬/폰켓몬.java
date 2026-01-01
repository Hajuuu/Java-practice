import java.util.*;
class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i : nums) {
            set.add(i);
        }
        int N = nums.length / 2;
        if(N < set.size()) {
            return N;
        } else {
            return set.size();
        }
    }
}
