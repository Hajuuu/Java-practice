class Solution {
    static int answer = 0;
    static int[] num;
    public int solution(int[] number) {
        num = number;
        dfs(0, 0, 0);
        return answer;
    }
    
    public static void dfs(int start, int count, int sum) {
        
        if(count == 3) {
            if(sum == 0) {
                answer++;
                return;
            }
        }
        
        for(int i = start; i < num.length; i++) {
            dfs(i + 1, count + 1, sum + num[i]);
        }
    }
}
