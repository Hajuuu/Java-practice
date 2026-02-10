import java.util.*;
class Solution {
    static int[] parent;
    public int solution(int n, int[][] costs) {
        Arrays.sort(costs, (o1, o2) -> o1[2] - o2[2]);
        parent = new int[n + 1];
        int answer = 0;
        
        for(int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        
        for(int[] cost : costs) {
            if(find(cost[0]) == find(cost[1])) {
                continue;
            }
            
            union(cost[0], cost[1]);
            answer += cost[2];
        }
        
        return answer;
    }
    
    
    public boolean union(int x, int y) {
        x = find(x);
        y = find(y);
        
        if(x == y) {
            return false;
        }
        
        if(x <= y) {
            parent[y] = x;
        } else {
            parent[x] = y;
        }
        
        return true;
    }
    
    public int find(int x) {
        if(parent[x] == x) {
            return x;
        }
        return find(parent[x]);
    }
}
