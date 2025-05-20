class Solution {
    
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<int[]>> nodeList = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            nodeList.add(new ArrayList<>());
        }

        for(int i = 0; i < times.length; i++) {
            int u = times[i][0];
            int v = times[i][1];
            int w = times[i][2];
            nodeList.get(u).add(new int[] {v, w});
        }

        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {k, 0});
        distance[k] = 0;
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            if(distance[cur[0]] != cur[1]) {
                continue;
            }
            for(int[] next : nodeList.get(cur[0])) {
                if(distance[next[0]] > cur[1] + next[1]) {
                    distance[next[0]] = cur[1] + next[1];
                    queue.offer(new int[] {next[0], cur[1] + next[1]});
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i = 1; i <= n; i++) {
            if(distance[i] == Integer.MAX_VALUE) {
                return -1;
            }
            max = Math.max(max, distance[i]);
        }
        return max;
    }
}
