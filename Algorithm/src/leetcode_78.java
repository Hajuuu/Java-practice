class Solution {
    static List<List<Integer>> answer;
    static List<Integer> numbers;
    public List<List<Integer>> subsets(int[] nums) {
        answer = new ArrayList<>();
        numbers = new ArrayList<>();
        findSubsets(nums, 0);
        return answer;
    }

    public void findSubsets(int[] nums, int start) {
        answer.add(new ArrayList<>(numbers));

        for(int i = start; i < nums.length; i++) {
            numbers.add(nums[i]);
            findSubsets(nums, i + 1);
            numbers.remove(numbers.size() - 1);
        }
    }
}
