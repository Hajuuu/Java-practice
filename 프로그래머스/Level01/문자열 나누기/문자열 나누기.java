class Solution {
    public int solution(String s) {
        int answer = 0;
        int count1 = 0;
        int count2 = 0;
        char now = s.charAt(0);
        boolean check = false;
        for(int i = 0; i < s.length(); i++) {
            check = false;
            if(s.charAt(i) == now) {
                count1++;
            } else {
                count2++;
            }
            
            if(count1 == count2) {
                
                answer++;
                count1 = 0;
                count2 = 0;
                if(i + 1 < s.length()) {
                    now = s.charAt(i + 1);
                }
                check = true;
            }
        }
        if(!check) {
            answer++;
        }
        return answer;
    }
}
