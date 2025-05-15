class Solution {
    static int[] dx = {0, 1, 0, -1, 1, 1, -1, -1};
    static int[] dy = {1, 0, -1, 0, 1, -1, 1, -1};
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1) {
            return -1;
        }
        int answer = bfs(grid, 0, 0);
        return answer;
    }

    public static int bfs(int[][] grid, int startX, int startY) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {startX, startY, 1});
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            if(cur[0] == grid.length - 1 && cur[1] == grid.length - 1) {
                return cur[2];
            }
            for(int i = 0; i < 8; i++) {
                int nowX = cur[0] + dx[i];
                int nowY = cur[1] + dy[i];
                if(nowX >= 0 && nowX < grid.length && nowY >= 0 && nowY < grid.length && grid[nowX][nowY] == 0) {
                    queue.offer(new int[] {nowX, nowY, cur[2] + 1});
                    grid[nowX][nowY] = 1;
                }
            }
        }
        return -1;
    }
}
