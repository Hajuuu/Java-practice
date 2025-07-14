import java.util.*;
class Solution {
    public int[] solution(String[] gems) {
        Map<String, Integer> gemCount = new HashMap<>();
        Set<String> gemType = new HashSet<>();
        for(String gem : gems) {
            gemType.add(gem);
        }
        int start = 0;
        int end = 0;
        int[] answer = new int[2];
        answer[0] = 0;
        answer[1] = gems.length - 1;
        gemCount.put(gems[start], 1);
        while(true) {
            if(gemType.size() <= gemCount.size()) {
                if(answer[1] - answer[0] > end - start) {
                    answer[0] = start;
                    answer[1] = end;
                }
                gemCount.put(gems[start], gemCount.get(gems[start]) - 1);
                if(gemCount.get(gems[start]) == 0) {
                    gemCount.remove(gems[start]);
                }
                start++;
                continue;
            }
            end++;
            if(end == gems.length) {
                break;
            }
            gemCount.put(gems[end], gemCount.getOrDefault(gems[end], 0)  + 1);
        }
        answer[0]++;
        answer[1]++;
        return answer;
    }
}
