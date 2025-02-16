import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        List<Integer> losts = new ArrayList<>();
        List<Integer> reserves = new ArrayList<>();
        
        for(int i : lost) {
            losts.add(i);
        }
        
        for(int i : reserve) {
            reserves.add(i);
        }
        Collections.sort(losts);
        Collections.sort(reserves);
        
        for(int i : lost) {
            if(reserves.contains(i)) {
                reserves.remove(new Integer(i));
                losts.remove(new Integer(i));
            }
        }
        
        answer = n - losts.size();
        
        for(int i : losts) {
            if(reserves.contains(i - 1)) {
                answer++;
                reserves.remove(new Integer(i - 1));
                continue;
            }
            if(reserves.contains(i + 1)) {
                answer++;
                reserves.remove(new Integer(i + 1));
            }
        }
        
        return answer;
    }
}
