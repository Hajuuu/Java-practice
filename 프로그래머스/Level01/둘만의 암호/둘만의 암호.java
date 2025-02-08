class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        for(int i = 0; i < s.length(); i++) {
            int count = 0;
            int check = 0;
            while(check != index) {
                count++;
                if(!skip.contains((char) (((s.charAt(i) - 'a' + count) % 26) + 'a') + "")) {
                    check++;
                }
            }
            answer += (char) ((s.charAt(i) - 'a' + count) % 26 + 'a');
        }
        return answer;
    }
}
