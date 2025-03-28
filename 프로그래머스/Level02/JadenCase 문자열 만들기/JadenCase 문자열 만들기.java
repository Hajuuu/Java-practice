class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        s = s.toLowerCase();
        int idx = -1;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' ') {
                idx = -1;
                sb.append(' ');
                continue;
            }
            idx++;
            if(idx == 0) {
                sb.append(Character.toUpperCase(s.charAt(i)));
                continue;
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
