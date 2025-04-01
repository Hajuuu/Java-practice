class Solution {
    public int solution(int n) {
        int answer = 0;
        int count1 = Integer.bitCount(n);
        for(int i = n + 1; i <= 1000000; i++) {
            if(Integer.bitCount(i) == count1) {
                answer = i;
                break;
            }
        }
        return answer;
    }
}
