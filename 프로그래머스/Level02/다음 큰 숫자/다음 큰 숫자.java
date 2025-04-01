class Solution {
    public int solution(int n) {
        int answer = 0;
        String str = Integer.toBinaryString(n);
        int length = count(str);
        for(int i = n + 1; i <= 1000000; i++) {
            if(count(Integer.toBinaryString(i)) == length) {
                answer = i;
                break;
            }
        }
        return answer;
    }
    
    public int count(String s) {
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }
}
