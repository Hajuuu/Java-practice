import java.util.*;
class Solution {
    static int[] islands;
    public int solution(int n, int[][] costs) {
        int answer = 0;
        Arrays.sort(costs, (o1, o2) -> {
            return o1[2] - o2[2];
        });
        islands = new int[n];
        for(int i = 0; i < n; i++) {
            islands[i] = i;
        }
        
        for(int i = 0; i < costs.length; i++) {
            if(find(costs[i][0]) != find(costs[i][1])) {
                union(costs[i][0], costs[i][1]);
                answer += costs[i][2];
            }
            
        }
        return answer;
    }
    
    public int find(int x) {
        if(islands[x] == x) {
            return x;
        }
        return islands[x] = find(islands[x]);
    }
    
    public void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a != b) {
            islands[b] = a;
        }
    }
}
