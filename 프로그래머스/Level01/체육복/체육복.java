import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        List<Integer> l = new ArrayList<>();
        List<Integer> r = new ArrayList<>();
        for(int num : reserve) {
            r.add(num);
        }
        
        for(int num : lost) {
            if(r.contains(Integer.valueOf(num))) {
                r.remove(Integer.valueOf(num));
                continue;
            }
            l.add(num);
        }
        
        int answer = n - l.size();
        Collections.sort(l);
        for(int num : l) {
            if(r.contains(Integer.valueOf(num - 1))) {
                r.remove(Integer.valueOf(num - 1));
                answer++;
            }
            else if(r.contains(Integer.valueOf(num + 1))) {
                r.remove(Integer.valueOf(num + 1));
                answer++;
            }
        }
        
        return answer;
    }
    
    
    
}
