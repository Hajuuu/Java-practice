class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        for(int i = 0; i < targets.length; i++) {
            for(int j = 0; j < targets[i].length(); j++) {
                int idx = find(keymap, targets[i].charAt(j) + "");
                if(idx == Integer.MAX_VALUE) {
                    answer[i] = -1;
                    break;
                }
                answer[i] += idx + 1;
            }
        }
        return answer;
    }
    
    public static int find(String[] keymap, String w) {
        int minNum = Integer.MAX_VALUE;
        for(int i = 0; i < keymap.length; i++) {
            if(keymap[i].indexOf(w) == -1) {
                continue;
            }
            minNum = Math.min(minNum, keymap[i].indexOf(w));
        }
        return minNum;
    }
}
