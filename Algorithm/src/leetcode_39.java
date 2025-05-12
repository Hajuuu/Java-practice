class Solution {
    static List<List<Integer>> answer;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        answer = new ArrayList<>();
        backtracking(candidates, target, new ArrayList<>(), 0, 0);
        return answer;
    }

    public static void backtracking(int[] candidates, int target, List<Integer> nums, int sum, int idx) {
        if(sum >= target) {
            if(sum == target) {
                answer.add(new ArrayList<>(nums));
            }
            return;
        }
        
        for(int i = idx; i < candidates.length; i++) {
            nums.add(candidates[i]);
            backtracking(candidates, target, nums, sum + candidates[i], i);
            nums.remove(nums.size() - 1);
        }
        
        
    }
}
