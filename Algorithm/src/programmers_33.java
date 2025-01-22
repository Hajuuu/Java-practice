import java.util.*;
class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> num = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            num.add(nums[i]);
        }
        if(nums.length / 2 < num.size()) {
            return nums.length / 2;
        }
        return num.size();
    }
}
