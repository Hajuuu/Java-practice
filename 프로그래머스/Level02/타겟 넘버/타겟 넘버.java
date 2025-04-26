class Solution {
    static int answer = 0;
    static int t;
    public int solution(int[] numbers, int target) {
        t = target;
        dfs(numbers, 0, 0);
        
        return answer;
    }
    
    public void dfs(int[] numbers, int sum, int idx) {
        if(idx == numbers.length) {
            if(sum == t) {
                answer++;
            }
            return;
        }
        dfs(numbers, sum + numbers[idx], idx + 1);
        dfs(numbers, sum - numbers[idx], idx + 1);
    }
}
