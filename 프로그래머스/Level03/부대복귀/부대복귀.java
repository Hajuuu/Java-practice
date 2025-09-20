import java.util.*;
class Solution {
    static List<List<Integer>> graph;
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        graph = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int i = 0; i < roads.length; i++) {
            int a = roads[i][0];
            int b = roads[i][1];
            
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        int[] distance = bfs(destination, n);
        int[] result = new int[sources.length];
        
        for(int i = 0; i < result.length; i++) {
            result[i] = distance[sources[i]];
        }
        
        return result;
    }
    
    public int[] bfs(int start, int n) {
        Deque<Integer> queue = new ArrayDeque<>();
        int[] distance = new int[n + 1];
        Arrays.fill(distance, -1);
        queue.offer(start);
        distance[start] = 0;
        while(!queue.isEmpty()) {
            int now = queue.poll();
            for(int i : graph.get(now)) {
                if(distance[i] != -1) {
                    continue;
                }
                distance[i] = distance[now] + 1;
                queue.offer(i);
            }
        }
        
        return distance;
    }
}
