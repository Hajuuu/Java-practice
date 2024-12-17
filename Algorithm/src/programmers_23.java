class Solution {
    public int[] solution(String s) {
        int[] check = new int[26];
        int[] answer = new int[s.length()];
        for(int i = 0; i < 26; i++) {
            check[i] = -1;
        }
        for(int i = 0; i < s.length(); i++) {
            int now = s.charAt(i) - 'a';
            if(check[now] == -1) {
                answer[i] = -1;
                check[now] = i;
                continue;
            }
            answer[i] = i - check[now];
            check[now] = i;
        }
        return answer;
    }
}
