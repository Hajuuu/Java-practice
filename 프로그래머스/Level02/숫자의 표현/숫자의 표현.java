class Solution {
    static int answer = 0;
    static boolean[] visit;
    public int solution(int n) {
        visit = new boolean[n + 1];
        for(int i = 1; i <= n; i++) {
            sum(n, i, i);
        }
        return answer;
    }
    
    public void sum(int n, int x, int total) {
        if(total >= n) {
            if(total == n) {
                answer++;
            }
            return;
        }
        sum(n, x + 1, total + (x + 1));
    }
}
