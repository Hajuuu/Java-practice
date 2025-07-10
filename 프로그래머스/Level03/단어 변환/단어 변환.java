class Solution {
    static int answer;
    static String t;
    static boolean[] visited;
    public int solution(String begin, String target, String[] words) {
        boolean check = false;
        answer = Integer.MAX_VALUE;
        t = target;
        for(int i = 0; i < words.length; i++) {
            if(words[i].equals(target)) {
                check = true;
                break;
            }
        }
        if(!check) {
            return 0;
        }
        visited = new boolean[words.length];
        findWord(begin, words, 0);
        return answer;
    }
    
    public static void findWord(String now, String[] words, int count) {
        if(now.equals(t)) {
            answer = Math.min(answer, count);
            return;
        }
        
        for(int i = 0; i < words.length; i++) {
            if(!visited[i] && isValid(now, words[i])) {
                visited[i] = true;
                findWord(words[i], words, count + 1);
                visited[i] = false;
            }
        }
        
    }
    
    public static boolean isValid(String start, String target) {
        
        int count = 0;
        for(int i = 0; i < start.length(); i++) {
            if(start.charAt(i) != target.charAt(i)) {
                count++;
            }
        }
        if(count == 1) {
            return true;
        }
        return false;
    }
}
