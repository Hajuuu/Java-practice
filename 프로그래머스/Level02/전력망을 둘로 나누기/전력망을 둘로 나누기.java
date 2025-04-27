import java.util.*;
class Solution {
    static List<List<Integer>> nodeList;
    static boolean[] visited;
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        nodeList = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            nodeList.add(new ArrayList<>());
        }
        
        for(int i = 0; i < wires.length; i++) {
            int u = wires[i][0];
            int v = wires[i][1];
            nodeList.get(u).add(v);
            nodeList.get(v).add(u);
        }
        
        for(int i = 0; i < wires.length; i++) {
            int u = wires[i][0];
            int v = wires[i][1];
            nodeList.get(u).remove(Integer.valueOf(v));
            nodeList.get(v).remove(Integer.valueOf(u));
            visited = new boolean[n + 1];
            int c = bfs(n, 1);
            nodeList.get(u).add(v);
            nodeList.get(v).add(u);
            answer = Math.min(answer, Math.abs(c - (n - c)));
        }
        
        return answer;
    }
    
    public static int bfs(int n, int start) {      
        int size = 0;
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start] = true;
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            size++;
            for(int i : nodeList.get(cur)) {
                if(visited[i]) {
                    continue;
                }
                visited[i] = true;
                queue.offer(i);
            }
        }
        return size;
    }
}
