import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes,(o1,o2) -> {
            if(o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });
        int[] now = new int[2];
        now[0] = routes[0][0];
        now[1] = routes[0][1];
        int count = 1;
        for(int i = 1; i < routes.length; i++) {
            if(now[0] <= routes[i][0] && now[1] >= routes[i][0]) {
                now[0] = routes[i][0];
                if(now[1] > routes[i][1]) {
                    now[1] = routes[i][1];
                }
                continue;
            } 
            count++;
            now[0] = routes[i][0];
            now[1] = routes[i][1];
        }
        return count;
    }
    
}
