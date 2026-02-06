import java.util.*;
class Solution {
    public int solution(int n, int[][] wires) {
        List<List<Integer>> nodeList = new ArrayList<>();
        int answer = Integer.MAX_VALUE;
        
        for(int i = 0; i <= n; i++) {
            nodeList.add(new ArrayList<>());
        }
        
        for(int[] wire : wires) {
            int u = wire[0];
            int v = wire[1];
            
            nodeList.get(u).add(v);
            nodeList.get(v).add(u);
        }
        
        for(int[] wire : wires) {
            int u = wire[0];
            int v = wire[1];
            
            nodeList.get(u).remove(Integer.valueOf(v));
            nodeList.get(v).remove(Integer.valueOf(u));
            int count = bfs(nodeList, 1, n);
            answer = Math.min(answer, Math.abs(count - (n - count)));
            nodeList.get(u).add(v);
            nodeList.get(v).add(u);
            
        }
        
        return answer;
        
        
    }
    
    
        public int bfs(List<List<Integer>> nodeList, int start, int n) {
            int count = 0;
            Queue<Integer> queue = new ArrayDeque<>();
            boolean[] visit = new boolean[n + 1];
            queue.offer(start);
            while(!queue.isEmpty()) {
                int now = queue.poll();
                for(int node : nodeList.get(now)) {
                    if(!visit[node]) {
                        visit[node] = true;
                        count++;
                        queue.offer(node);
                    }
                }   
            }
            return count;
            
        }
}
