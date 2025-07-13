import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (o1, o2) -> {
            return o1[1] - o2[1];
        });
        for(int i = 0; i < routes.length; i++) {
            System.out.println(routes[i][0] + " " + routes[i][1]);
        }
        int camera = Integer.MIN_VALUE;
        int count = 0;
        for(int i = 0; i < routes.length; i++) {
            if(routes[i][0] > camera) {
                count++;
                camera = routes[i][1];
            } 
        }
        return count;
    }
    
}
