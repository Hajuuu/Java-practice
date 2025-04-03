class Solution {
    public String solution(String number, int k) {
        int len = number.length() - k;
        int start = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < len; i++) {
            int max = 0;
            for(int j = start; j <= i + k; j++) {
                if(number.charAt(j) - '0' > max) {
                    start = j + 1;
                    max = number.charAt(j) - '0';
                }
            }
            sb.append(max);
        }
        return sb.toString();
    }
}
