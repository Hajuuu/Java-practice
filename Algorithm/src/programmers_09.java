class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        for(int i = left; i <= right; i++) {
            if(i % Math.sqrt(i) == 0) {
                answer -= i;
                continue;
            }
            answer += i;
        }
        return answer;
    }
}
