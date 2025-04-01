class Solution {
    static int[] answer;
    public int[] solution(String s) {
        answer = new int[2];
        while(true) {
            if(s.equals("1")) {
                break;
            }
            s = toBinary(s);
        }
        return answer;
    }
    
    public static String toBinary(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '1') {
                sb.append("1");
            }
        }
        String newStr = sb.toString();
        answer[0]++;
        answer[1] += s.length() - newStr.length();
        
        return Integer.toBinaryString(newStr.length());
    }
}
