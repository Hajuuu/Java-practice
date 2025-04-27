import java.util.*;
class Solution {
    static List<List<Integer>> nodeList;
    static boolean[] visited;
    public int solution(int n, int[][] computers) {
        visited = new boolean[n + 1];
        nodeList = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            nodeList.add(new ArrayList<>());
        }
        
        for(int i = 0; i < computers.length; i++) {
            for(int j = 0; j < computers[i].length; j++) {
                if(computers[i][j] == 1) {
                    nodeList.get(i + 1).add(j + 1);
                }
            } 
        }
        
        int count = 0;
        for(int i = 1; i <= n; i++) {
            if(!visited[i]) {
                dfs(i);
                count++;
            }
        }
        return count;
    }
    
    public void dfs(int start) {
        visited[start] = true;
        
        for(int i = 0; i < nodeList.get(start).size(); i++) {
            int now = nodeList.get(start).get(i);
            if(visited[now]) {
                continue;
            }
            dfs(now);
        }
    }
}
