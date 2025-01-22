class Solution {
    public int solution(int n, int m, int[] section) {
        int start = section[0];
        int answer = 1;
        for(int i = 0; i < section.length; i++) {
            if(section[i] >= start + m) {
                start = section[i];
                answer++;
            }
        }
        return answer;
    }
}
