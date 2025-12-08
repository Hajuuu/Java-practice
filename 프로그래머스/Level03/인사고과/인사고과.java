import java.util.*;
class Solution {
    public int solution(int[][] scores) {
        int answer = 1;
        int[] wanho = scores[0];
        Arrays.sort(scores, (o1, o2) -> {
            if(o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o2[0] - o1[0];
        });
        
        int maxScore = Integer.MIN_VALUE;
        for(int[] score : scores) {
            if(score[1] < maxScore) {
                if(score[0] == wanho[0] && score[1] == wanho[1]) {
                    return -1;
                }
                continue;
            }
            if(wanho[0] + wanho[1] < score[0] + score[1]) {
                answer++;
            }
            maxScore = Math.max(maxScore, score[1]);
        }
        
        return answer;
    }
}
