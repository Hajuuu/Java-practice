class Solution {
    public String solution(String s, int n) {
        String answer = "";
        for(int i = 0; i < s.length(); i++) {
            char num = s.charAt(i);
            if(num >= 'a' && num <= 'z') {
                 num = (char) ((num - 'a' + n) % 26 + 'a');
            }
            else if(num >= 'A' && num <= 'Z') {
                num = (char) ((num - 'A' + n) % 26 + 'A');
            }
            answer += num;
            
        }
        return answer;
    }
}
