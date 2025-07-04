import java.util.*;
class Solution {
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        List<List<int[]>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int[] path : paths) {
            int u = path[0];
            int v = path[1];
            int w = path[2];
            
            graph.get(u).add(new int[] {v, w});
            graph.get(v).add(new int[] {u, w});
        }
        
        Set<Integer> summit = new HashSet<>();
        for(int i = 0; i < summits.length; i++) {
            summit.add(summits[i]);
        }
        
        int[] intensity = new int[n + 1];
        Arrays.fill(intensity, Integer.MAX_VALUE);
        
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        
        for(int gate : gates) {
            queue.offer(new int[] {gate, 0});
            intensity[gate] = 0;
        }
        
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            if(summit.contains(cur[0])) {
                continue;
            }
            if(intensity[cur[0]] < cur[1]) {
                continue;
            }
            for(int[] next : graph.get(cur[0])) {
                int max = Math.max(next[1], intensity[cur[0]]);
                if(max < intensity[next[0]]) {
                    intensity[next[0]] = max;
                    queue.offer(new int[] {next[0], max});
                }
            }
            
        }
        
        Arrays.sort(summits);
        int minSummit = 0;
        int minIntensity = Integer.MAX_VALUE;
            
        for(int sum : summits) {
            if(intensity[sum] < minIntensity) {
                minIntensity = intensity[sum];
                minSummit = sum;
            }
        }
            
        return new int[] {minSummit, minIntensity};
    }

}
